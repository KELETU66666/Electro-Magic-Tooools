package com.keletu.emt.init;

import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.blocks.BlocksTC;

public class EMTOreDictionary{
    public static void setup(){
        OreDictionary.registerOre("slimeball",EMTItems.materials_glue);
        OreDictionary.registerOre("oreAmber", BlocksTC.oreAmber);
        OreDictionary.registerOre("oreCinnabar", BlocksTC.oreCinnabar);
    }
}
