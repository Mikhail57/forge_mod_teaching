package ru.mineclass.circlemod.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import ru.mineclass.circlemod.generator.BlockWorldGenerator;
import ru.mineclass.circlemod.register.BlocksRegister;
import ru.mineclass.circlemod.register.ItemsRegister;

/**
 * Базовый класс-прокси, описывающий базовые события
 */
public abstract class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BlocksRegister.register();
        ItemsRegister.register();
        GameRegistry.registerWorldGenerator(new BlockWorldGenerator(), 5);
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
