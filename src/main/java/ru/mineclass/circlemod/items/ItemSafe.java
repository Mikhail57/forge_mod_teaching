package ru.mineclass.circlemod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSafe extends Item {
    public static final String name = "safecircle";
    public ItemSafe() {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
