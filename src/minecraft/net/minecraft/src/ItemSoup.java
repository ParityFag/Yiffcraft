// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemFood, ItemStack, Item, World, 
//            EntityPlayer

public class ItemSoup extends ItemFood
{

    public ItemSoup(int i, int j)
    {
        super(i, j, false);
        setMaxStackSize(1);
    }

    public ItemStack onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        super.onFoodEaten(itemstack, world, entityplayer);
        return new ItemStack(Item.bowlEmpty);
    }
}