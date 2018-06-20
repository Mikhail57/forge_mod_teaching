package ru.mineclass.circlemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import ru.mineclass.circlemod.proxy.CommonProxy;

/**
 * Класс, содержащий главную информацию по моду:
 * - modid,
 * - имя,
 * - версию
 */
@Mod(modid = MyAwesomeMod.MODID, name = MyAwesomeMod.NAME, version = MyAwesomeMod.VERSION)
public class MyAwesomeMod {
    public static final String MODID = "circlemod";
    public static final String NAME = "Circle Mod";
    public static final String VERSION = "0.1-dev";

    private static Logger logger;

    /**
     * Прокси для нормального функционирования мода
     */
    @SidedProxy(clientSide = "ru.mineclass.circlemod.proxy.ClientProxy",
            serverSide = "ru.mineclass.circlemod.proxy.ServerProxy")
    private static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
