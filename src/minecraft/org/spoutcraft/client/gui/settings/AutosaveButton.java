/*
 * This file is part of Spoutcraft (http://www.spout.org/).
 *
 * Spoutcraft is licensed under the SpoutDev License Version 1.
 *
 * Spoutcraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Spoutcraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.client.gui.settings;

import net.minecraft.client.Minecraft;

import org.spoutcraft.client.config.ConfigReader;
import org.spoutcraft.spoutcraftapi.event.screen.ButtonClickEvent;

public class AutosaveButton extends AutomatedButton{
	public AutosaveButton() {
		setTooltip("Autosave interval\nDefault autosave interval (2s) is NOT RECOMMENDED.\nAutosave causes the famous Lag Spike of Death.");
	}

	@Override
	public String getText() {
		switch(ConfigReader.autosave) {
			case 0: return "Autosave: 30 min";
			case 1: return "Autosave: 3 min";
			case 2: return "Autosave: 1 min";
			case 3: return "Autosave: 30 sec";
			case 4: return "Autosave: 10 sec";
			case 5: return "Autosave: 2 sec";
		}
		return "Unknown State: " + ConfigReader.autosave;
	}

	@Override
	public void onButtonClick(ButtonClickEvent event) {
		ConfigReader.autosave++;
		if (ConfigReader.autosave > 5) {
			ConfigReader.autosave = 0;
		}
		ConfigReader.write();

		if (Minecraft.theMinecraft.theWorld != null) {
			Minecraft.theMinecraft.theWorld.autosavePeriod = getAutosaveTicks();
		}
	}

	public static int getAutosaveTicks() {
		switch(ConfigReader.autosave) {
			case 0: return 30 * 60 * 20;
			case 1: return 3 * 60 * 20;
			case 2: return 60 * 20;
			case 3: return 30 * 20;
			case 4: return 10 * 20;
			case 5: return 2 * 20;
			default: return 40;
		}
	}
}
