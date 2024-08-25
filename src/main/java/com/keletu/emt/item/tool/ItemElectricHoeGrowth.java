/*******************************************************************************
 * Copyright (c) 2014 Tombenpotter.
 * All rights reserved. 
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at http://www.gnu.org/licenses/gpl.html
 *
 * This class was made by Tombenpotter and is distributed as a part of the Electro-Magic Tools mod.
 * Electro-Magic Tools is a derivative work on Thaumcraft 4 (c) Azanor 2012.
 * http://www.minecraftforum.net/topic/1585216-
 ******************************************************************************/

package com.keletu.emt.item.tool;

import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.utils.Utils;

public class ItemElectricHoeGrowth extends ItemHoe implements IElectricItem {

    public int maxCharge = 1000000;
    public int growthCost = 1000;
    public int tillCost = 100;

    public ItemElectricHoeGrowth() {
        super(ToolMaterial.DIAMOND);
        this.setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        this.setMaxStackSize(1);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == EMTCreativeTabs.EMT_CREATIVEtabs) {
            ItemStack charged = new ItemStack(this, 1);
            ElectricItem.manager.charge(charged, 2147483647, 2147483647, true, false);
            items.add(charged);
            items.add(new ItemStack(this, 1, getMaxDamage()));
        }
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (player.isSneaking()) {
            return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
        }
        boolean did = false;
        for (int xx = -1; xx <= 1; ++xx) {
            for (int zz = -1; zz <= 1; ++zz) {
                if (super.onItemUse(player, world, pos.add(xx, 0, zz), hand, facing, hitX, hitY, hitZ) == EnumActionResult.SUCCESS) {
                    if (world.isRemote) {
                        BlockPos pp = pos.add(xx, 0, zz);
                        FXDispatcher.INSTANCE.drawBamf(pp.getX() + 0.5, pp.getY() + 1.01, pp.getZ() + 0.5, 0.3f, 0.12f, 0.1f, xx == 0 && zz == 0, false, EnumFacing.UP);
                    }
                    if (!did) {
                        did = true;
                    }
                }
            }
        }
        if (!did && ElectricItem.manager.canUse(stack,growthCost)) {
            did = Utils.useBonemealAtLoc(world, player, pos);
            if (did) {
                player.getHeldItem(hand).damageItem(3, player);
                ElectricItem.manager.use(stack,growthCost,player);
                if (!world.isRemote) {
                    world.playBroadcastSound(2005, pos, 0);
                }
                else {
                    FXDispatcher.INSTANCE.drawBlockMistParticles(pos, 990099);
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    /* IC2 API METHODS */

    @Override
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return maxCharge;
    }

    @Override
    public int getTier(ItemStack itemStack) {
        return 3;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return 1000;
    }
}