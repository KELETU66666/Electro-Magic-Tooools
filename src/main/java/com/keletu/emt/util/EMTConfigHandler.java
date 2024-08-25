package com.keletu.emt.util;

import com.keletu.emt.ElectroMagicTools;
import net.minecraftforge.common.config.Config;


@Config(modid = ElectroMagicTools.MOD_ID)
@Config.LangKey("emt.config.title")
public class EMTConfigHandler {

    @Config.Name("Tools for Arcane Bore")
    @Config.Comment("This will augment the durablilty of the tools, and will also decrease the EU cost to 1. \" + \"The tools should have the same number of uses than before.")
    public static boolean toolsInBore = false;

    @Config.Name("Enable enchanting tools")
    @Config.Comment("Warning: the enchantability is low.")
    public static boolean enchanting = false;

    @Config.Name("Enable night vision")
    @Config.Comment("Night vision.")
    public static boolean nightVisionOff = false;

    @Config.Name("Impact of rain")
    @Config.Comment("The impact of rain on all wings")
    public static boolean impactOfRain = true;

    @Config.Name("Aer Output")
    @Config.RangeDouble(min = 0)
    public static double airOutput = 15000;

    @Config.Name("Aqua Output")
    @Config.RangeDouble(min = 0)
    public static double waterOutput = 5000;

    @Config.Name("Ignis Output")
    @Config.RangeDouble(min = 0)
    public static double fireOutput = 20000;
    @Config.Name("Ordo Output")
    @Config.RangeDouble(min = 0)
    public static double orderOutput = 16000;
    @Config.Name("Perditio Output")
    @Config.RangeDouble(min = 0)
    public static double entropyOutput = 10000;
    @Config.Name("Terra Output")
    @Config.RangeDouble(min = 0)
    public static double earthOutput = 2000;

    @Config.Name("Output Cap")
    @Config.RangeDouble(min = -1)
    public static double outputCap = -1;

    @Config.Name("Inventory Charging Ring production")
    @Config.RangeInt(min = 0)
    public static int inventoryBaubleProdution = 32;

    @Config.Name("Armor Charging Ring production")
    @Config.RangeInt(min = 0)
    public static int armorBaubleProduction = 32;

    @Config.Name("Electric Speed Boost")
    @Config.RangeDouble(min = 0)
    public static double electricBootsSpeedBust = 0.09;
    @Config.Name("Nano Speed Boost")
    @Config.RangeDouble(min = 0)
    public static double nanoBootsSpeedBust = 0.11;
    @Config.Name("Quantum Speed Boost")
    @Config.RangeDouble(min = 0)
    public static double quantumBootsSpeedBust = 0.13;

    @Config.Name("Electric Jump Boost")
    @Config.RangeDouble(min = 0)
    public static double electricJumpBust = 0.3;
    @Config.Name("Nano Jump Boost")
    @Config.RangeDouble(min = 0)
    public static double nanoBootsJumpBust = 0.35;
    @Config.Name("Quantum Jump Boost")
    @Config.RangeDouble(min = 0)
    public static double quantumBootsJumpBust = 0.5;

    @Config.Name("Compressed Solar Panel Output")
    @Config.RangeDouble(min = 0)
    public static double compressedSolarOutput = 10;

    @Config.Name("Double Compressed Solar Panel Output")
    @Config.RangeDouble(min = 0)
    public static double doubleCompressedSolarOutput = 100;
    @Config.Name("Triple Compressed Solar Panel Output")
    @Config.RangeDouble(min = 0)
    public static double tripleCompressedSolarOutput = 1000;
    @Config.Name("Ticks Generator")
    @Config.RangeInt(min = 0)
    public static int essenstialGeneratorTicks = 120;
    //@Config.Name("Mjolnir")
    //public static boolean thorHammerResearch = false;
}
