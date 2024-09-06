package com.keletu.emt.block.solar.order;

import com.keletu.emt.tile.solar.order.TileEntityTripleOrderSolar;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTripleOrderCompressedSolar extends BlockContainer {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public BlockTripleOrderCompressedSolar(Material iron) {
        super(iron);
        this.setHardness(4.0F);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityTripleOrderSolar();
    }
}
