package com.keletu.emt.tile.generator;

import com.keletu.emt.util.EMTEssentiasOutputs;
import thaumcraft.api.aspects.Aspect;

public class TileEntityFireGenerator extends TileEnitytBaseGeneratorAspect {

    public TileEntityFireGenerator(){
        aspect= Aspect.FIRE;
        output= EMTEssentiasOutputs.outputs.get(aspect.getTag());

    }
}
