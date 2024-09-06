// Decompiled with: Procyon 0.6.0
// Class Version: 8
package com.keletu.emt.block.solar.water;

import com.keletu.emt.init.EMTBlocks;
import com.keletu.emt.tile.solar.water.TileEntityDoubleWaterSolar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockDoubleWaterCompressedSolar extends BlockContainer
{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockDoubleWaterCompressedSolar(final Material iron) {
        super(iron);
    }

    public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
        return Item.getItemFromBlock(EMTBlocks.solar_waterdoublecompressed);
    }

    public EnumBlockRenderType getRenderType(final IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public boolean isOpaqueCube(final IBlockState state) {
        return false;
    }

    public boolean isFullCube(final IBlockState state) {
        return false;
    }

    @Nullable
    public TileEntity createNewTileEntity(final World worldIn, final int meta) {
        return new TileEntityDoubleWaterSolar();
    }
}
