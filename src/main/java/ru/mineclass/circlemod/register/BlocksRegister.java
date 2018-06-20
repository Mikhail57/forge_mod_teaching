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

/**
 * Класс-помощник для регистрации блока в игре
 */
public class BlocksRegister {
    public static CirclesBlock block = new CirclesBlock("circleblock");

    /**
     * Список блоков, которые мы хотим инициализировать
     */
    private static final Block[] blocks = {
            block
    };

    /**
     * Метод для регистрации блока
     */
    public static void register() {
        setRegister(blocks);
    }

    /**
     * Метод для регистрации модели нашего блока
     */
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(blocks);
    }

    /**
     * Внутренний вспомогательный метод для регистрации
     * @param blocks блоки для регистрации
     */
    private static void setRegister(Block[] blocks) {
        for (Block b : blocks) {
            ForgeRegistries.BLOCKS.register(b);
            ForgeRegistries.ITEMS.register(
                    new ItemBlock(block).setRegistryName(b.getRegistryName())
            );
        }
    }

    /**
     * Внутренний вспомогательный метод для регистрации моделей блоков
     * @param blocks блоки для регистрации
     */
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
