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
import com.keletu.emt.util.EMTConfigHandler;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemThaumiumDrill extends ItemPickaxe implements IElectricItem {

    public int maxCharge = 60000;
    public int cost;
    public int tier = 2;
    public double transferLimit = 100;

    public ItemThaumiumDrill() {
        super(ToolMaterial.DIAMOND);
        this.efficiency = 20F;
        this.setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        this.setMaxStackSize(1);
        if (EMTConfigHandler.toolsInBore == false) {
            this.setMaxDamage(27);
        } else {
            this.setMaxDamage(240);
        }
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
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (EMTConfigHandler.toolsInBore == false) {
            cost = 250;
        } else {
            cost = 1;
        }
        ElectricItem.manager.use(stack, cost, entityLiving);
        return true;
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        return Items.DIAMOND_PICKAXE.canHarvestBlock(blockIn) || Items.DIAMOND_SHOVEL.canHarvestBlock(blockIn);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (!ElectricItem.manager.canUse(stack, cost)) {
            return 1.0F;
        }

        if (Items.WOODEN_PICKAXE.getDestroySpeed(stack, state) > 1.0F || Items.WOODEN_SHOVEL.getDestroySpeed(stack, state) > 1.0F) {
            return efficiency;
        } else {
            return super.getDestroySpeed(stack, state);
        }
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
        return true;
    }

    //@Override
    //public boolean onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
    //    return RandomHelper.placeTorch(player, world, pos, side, hitX, hitY, hitZ);
    //}

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public int getItemEnchantability() {
        if (EMTConfigHandler.enchanting == false) {
            return 0;
        } else {
            return 4;
        }
    }

    @Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
        return EMTConfigHandler.enchanting;
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
        return tier;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return transferLimit;
    }
}