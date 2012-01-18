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

package org.spoutcraft.client.entity;

import net.minecraft.src.Entity;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

import org.spoutcraft.client.io.CustomTextureManager;

public class EntityTexture extends Entity {
	private String url = null;
	org.newdawn.slick.opengl.Texture texture = null;
	private boolean rotateWithPlayer = true;
	private float scale = 1.0F;

	public EntityTexture(World var1) {
		super(var1);
	}

	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) {
		url = var1.getString("url");
		rotateWithPlayer = var1.getBoolean("rotateWithPlayer");
		scale = var1.getFloat("scale");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) {
		var1.setString("url", url);
		var1.setBoolean("rotateWithPlayer", rotateWithPlayer);
		var1.setFloat("scale", scale);
	}

	public void setUrl(String url) {
		this.url = url;
		if (getUrl() != null) {
			CustomTextureManager.downloadTexture(url);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setRotateWithPlayer(boolean rotateWithPlayer) {
		this.rotateWithPlayer = rotateWithPlayer;
	}

	public boolean isRotateWithPlayer() {
		return rotateWithPlayer;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getHeight() {
		return this.height;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getWidth() {
		return this.width;
	}
}
