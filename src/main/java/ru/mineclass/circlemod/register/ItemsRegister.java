package ru.mineclass.circlemod.register;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.mineclass.circlemod.items.ItemSafe;

import java.util.ArrayList;

public class ItemsRegister {
    static Item item = new ItemSafe();
    static Item[] items = {
            item,
    };

    public static void register() {
        setRegister(items);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(items);
    }

    private static void setRegister(Item[] items) {
        ForgeRegistries.ITEMS.registerAll(items);
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Item[] items) {
        for (Item item : items)
            Minecraft
                    .getMinecraft()
                    .getRenderItem()
                    .getItemModelMesher()
                    .register(item, 0,
                            new ModelResourceLocation(
                                    item.getRegistryName(), "inventory"));
    }

}
