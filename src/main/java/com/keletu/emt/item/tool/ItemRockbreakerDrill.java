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
 *
 * This class originally belongs to Azanor, but with his permission I took it, and modified it to make it work as I wanted to.
 ******************************************************************************/

package com.keletu.emt.item.tool;

import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.util.EMTConfigHandler;
import ic2.api.item.ElectricItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.FMLCommonHandler;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;
import thaumcraft.common.lib.utils.BlockUtils;

public class ItemRockbreakerDrill extends ItemThaumiumDrill {

    EnumFacing side;
    public int hitCost = 400;

    public ItemRockbreakerDrill() {
        side = EnumFacing.DOWN;
        setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        this.efficiency = 25F;
        this.setMaxStackSize(1);
        if (!EMTConfigHandler.toolsInBore) {
            this.setMaxDamage(27);
        } else {
            this.setMaxDamage(2571);
        }
        maxCharge = 900000;
        transferLimit = 900;
        tier = 3;
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == EMTCreativeTabs.EMT_CREATIVEtabs || tab == CreativeTabs.SEARCH) {
            ItemStack w1 = new ItemStack(this);
            EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.REFINING, 1);
            EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.DESTRUCTIVE, 1);
            EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.SOUNDING, 2);
            items.add(w1);
        } else {
            super.getSubItems(tab, items);
        }
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        RayTraceResult movingobjectposition = BlockUtils.getTargetBlock(player.world, player, true);
        if (movingobjectposition != null && movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK) {
            side = movingobjectposition.sideHit;
        }
        return super.onBlockStartBreak(itemstack, pos, player);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        if (!player.world.isRemote) {
            if (!(entity instanceof EntityPlayer) || FMLCommonHandler.instance().getMinecraftServerInstance().isPVPEnabled()) {
                entity.setFire(2);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
        if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
            entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 12F);
        }
        return false;
    }
}