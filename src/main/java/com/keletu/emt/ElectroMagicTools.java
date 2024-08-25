package com.keletu.emt;


import com.keletu.emt.command.CommandOutput;
import com.keletu.emt.init.*;
import com.keletu.emt.item.events.BootsFallEvent;
import com.keletu.emt.proxy.CommonProxy;
import com.keletu.emt.util.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;

@Mod(
        modid = ElectroMagicTools.MOD_ID,
        name = ElectroMagicTools.NAME,
        version = ElectroMagicTools.VERSION,
        dependencies = ElectroMagicTools.DEPENDS

)
public class ElectroMagicTools {


    public static final String NAME = "Industrial Magic - Crossover IC2";
    public static final String MOD_ID = "emt";
    public static final String VERSION = "12.2.0";
    public static final String TEXTURE_PATH = "emt";
    public static final String CLIENT_PROXY = "com.keletu.emt.proxy.ClientProxy";
    public static final String COMMON_PROXY = "com.keletu.emt.proxy.CommonProxy";
    public static final String CHANNEL = "EMT";
    public static final String DEPENDS = "required-after:thaumcraft@[6.1.BETA26,);required-after:ic2@[2.8.197-ex112,)";

    @SidedProxy(
            clientSide = CLIENT_PROXY,
            serverSide = COMMON_PROXY
    )
    public static CommonProxy proxy;
    public static final Logger LOGGER = LogManager.getLogger(NAME);
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL);
    public static ResearchCategory RES_CAT;


    @Instance(MOD_ID)
    public static ElectroMagicTools instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {


        instance = this;
        LOGGER.info("Registration Blocks...");
        EMTBlocks.init();
        EMTBlocks.InGameRegister();
        LOGGER.info("Registration Blocks Complete.");
        LOGGER.info("Registration Items...");
        EMTItems.init();
        EMTItems.InGameRegister();
        LOGGER.info("Registration Items Complete.");

        FMLCommonHandler.instance().bus().register(new EMTEventHandler());
        if (FMLCommonHandler.instance().getSide().isClient()) {
            FMLCommonHandler.instance().bus().register(new EMTClientHandler());

        }

        EMTEssentiasOutputs.addPrimalOutputs();
        EMTEssentiasOutputs.addOutputs();

        registerPackets();


    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        EMTOreDictionary.setup();
        RES_CAT = ResearchCategories.registerCategory(catName, "WIP"/*"UNLOCKARTIFICE"*/, null, icon, back, back2);
        EMTEntities.registerEMTEntities();
        LOGGER.info("Registration Recipes...");
        EMTRecipes.setup();
        EMTThauminiconsRecipes.setup();
        EMTIC2Recipes.setup();
        LOGGER.info("Registration Recipes Complete");
        EMTTile.registerTiles();
        MinecraftForge.EVENT_BUS.register(new BootsFallEvent());
        proxy.load();

    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void onFMLServerStart(FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandOutput());
    }

    public void registerPackets() {

    }

    public static final String catName = "EMT";
    public static final ResourceLocation icon = new ResourceLocation("emt", "textures/misc/emt.png");
    public static final ResourceLocation back = new ResourceLocation("emt", "textures/misc/background.png");
    public static final ResourceLocation back2 = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");
}
