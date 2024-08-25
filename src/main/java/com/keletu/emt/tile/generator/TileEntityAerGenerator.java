package com.keletu.emt.tile.generator;

import com.keletu.emt.util.EMTEssentiasOutputs;
import thaumcraft.api.aspects.Aspect;

public class TileEntityAerGenerator extends TileEnitytBaseGeneratorAspect {

    public TileEntityAerGenerator() {
        aspect = Aspect.AIR;
        output = EMTEssentiasOutputs.outputs.get(aspect.getTag());
    }
}
