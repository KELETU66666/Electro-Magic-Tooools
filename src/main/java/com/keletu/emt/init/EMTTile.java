package com.keletu.emt.init;



import com.keletu.emt.tile.generator.TileEntityAerGenerator;
import com.keletu.emt.tile.generator.TileEntityAuramGenerator;
import com.keletu.emt.tile.generator.TileEntityFireGenerator;
import com.keletu.emt.tile.generator.TileEntityPotentiaGenerator;
import com.keletu.emt.tile.solar.air.TileEntityAirSolar;
import com.keletu.emt.tile.solar.air.TileEntityDoubleAirSolar;
import com.keletu.emt.tile.solar.air.TileEntityTripleAirSolar;
import com.keletu.emt.tile.solar.compressed.TileEntityCompressedSolar;
import com.keletu.emt.tile.solar.compressed.TileEntityDoubleCompressedSolar;
import com.keletu.emt.tile.solar.compressed.TileEntityTripleCompressedSolar;
import com.keletu.emt.tile.solar.dark.TileEntityDarkSolar;
import com.keletu.emt.tile.solar.dark.TileEntityDoubleDarkSolar;
import com.keletu.emt.tile.solar.dark.TileEntityTripleDarkSolar;
import com.keletu.emt.tile.solar.earth.TileEntityDoubleEarthSolar;
import com.keletu.emt.tile.solar.earth.TileEntityEarthSolar;
import com.keletu.emt.tile.solar.earth.TileEntityTripleEarthSolar;
import com.keletu.emt.tile.solar.fire.TileEntityDoubleFireSolar;
import com.keletu.emt.tile.solar.fire.TileEntityFireSolar;
import com.keletu.emt.tile.solar.fire.TileEntityTripleFireSolar;
import com.keletu.emt.tile.solar.order.TileEntityDoubleOrderSolar;
import com.keletu.emt.tile.solar.order.TileEntityOrderSolar;
import com.keletu.emt.tile.solar.order.TileEntityTripleOrderSolar;
import com.keletu.emt.tile.solar.water.TileEntityDoubleWaterSolar;
import com.keletu.emt.tile.solar.water.TileEntityTripleWaterSolar;
import com.keletu.emt.tile.solar.water.TileEntityWaterSolar;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EMTTile {

    public static void registerTiles() {
       GameRegistry.registerTileEntity(TileEntityCompressedSolar.class, "tileEntityCompressedSolar");
       GameRegistry.registerTileEntity(TileEntityDoubleCompressedSolar.class, "tileEntityDoubleCompressedSolar");
       GameRegistry.registerTileEntity(TileEntityTripleCompressedSolar.class, "tileEntityTripleCompressedSolar");

        GameRegistry.registerTileEntity(TileEntityAirSolar.class, "tileEntityAirSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleAirSolar.class, "tileEntityDoubleAirSolar");
        GameRegistry.registerTileEntity(TileEntityTripleAirSolar.class, "TileEntityTripleAirSolar");

        GameRegistry.registerTileEntity(TileEntityDarkSolar.class, "TileEntityDarkSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleDarkSolar.class, "TileEntityDoubleDarkSolar");
        GameRegistry.registerTileEntity(TileEntityTripleDarkSolar.class, "TileEntityTripleDarkSolar");

        GameRegistry.registerTileEntity(TileEntityEarthSolar.class, "TileEntityEarthSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleEarthSolar.class, "TileEntityDoubleEarthSolar");
        GameRegistry.registerTileEntity(TileEntityTripleEarthSolar.class, "TileEntityTripleEarthSolar");

        GameRegistry.registerTileEntity(TileEntityFireSolar.class, "TileEntityFireSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleFireSolar.class, "TileEntityDoubleFireSolar");
        GameRegistry.registerTileEntity(TileEntityTripleFireSolar.class, "TileEntityTripleFireSolar");

        GameRegistry.registerTileEntity(TileEntityOrderSolar.class, "TileEntityOrderSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleOrderSolar.class, "TileEntityDoubleOrderSolar");
        GameRegistry.registerTileEntity(TileEntityTripleOrderSolar.class, "TileEntityTripleOrderSolar");

        GameRegistry.registerTileEntity(TileEntityOrderSolar.class, "TileEntityOrderSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleOrderSolar.class, "TileEntityDoubleOrderSolar");
        GameRegistry.registerTileEntity(TileEntityTripleOrderSolar.class, "TileEntityTripleOrderSolar");

        GameRegistry.registerTileEntity(TileEntityWaterSolar.class, "TileEntityWaterSolar");
        GameRegistry.registerTileEntity(TileEntityDoubleWaterSolar.class, "TileEntityDoubleWaterSolar");
        GameRegistry.registerTileEntity(TileEntityTripleWaterSolar.class, "TileEntityTripleWaterSolar");

        GameRegistry.registerTileEntity(TileEntityAerGenerator.class,"TileEntityAerGenerator");
        GameRegistry.registerTileEntity(TileEntityAuramGenerator.class,"TileEntityAuramGenerator");
        GameRegistry.registerTileEntity(TileEntityPotentiaGenerator.class,"TileEntityPotentiaGenerator");
        GameRegistry.registerTileEntity(TileEntityFireGenerator.class,"TileEntityFireGenerator");

    }
}
