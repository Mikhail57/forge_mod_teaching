package ru.mineclass.circlemod.register;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import ru.mineclass.circlemod.blocks.CirclesBlock;

public class BlocksRegister {
    public static CirclesBlock block = new CirclesBlock("circleblock");

    private static final Block[] blocks = {
            block
    };

    public static void register() {
        setRegister(blocks);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(blocks);
    }

    private static void setRegister(Block[] blocks) {
        for (Block b : blocks) {
            ForgeRegistries.BLOCKS.register(b);
            ForgeRegistries.ITEMS.register(
                    new ItemBlock(block).setRegistryName(b.getRegistryName())
            );
        }
    }

    @SideOnly(Side.CLIENT)
    private static void setRender(Block[] blocks) {
        for (Block b : blocks) {
            Minecraft
                    .getMinecraft()
                    .getRenderItem()
                    .getItemModelMesher()
                    .register(
                            Item.getItemFromBlock(b), 0,
                            new ModelResourceLocation(
                                    b.getRegistryName(),
                                    "inventory"));
        }

    }


}
