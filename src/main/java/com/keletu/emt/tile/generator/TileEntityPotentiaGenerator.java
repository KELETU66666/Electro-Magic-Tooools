package com.keletu.emt.tile.generator;

import com.keletu.emt.util.EMTEssentiasOutputs;
import thaumcraft.api.aspects.Aspect;

public class TileEntityPotentiaGenerator extends TileEnitytBaseGeneratorAspect {

    public TileEntityPotentiaGenerator(){
        aspect= Aspect.ENERGY;
        output= EMTEssentiasOutputs.outputs.get(aspect.getTag());

    }
}
