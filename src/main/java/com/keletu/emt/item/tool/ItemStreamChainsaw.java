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
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;
import thaumcraft.common.lib.utils.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class ItemStreamChainsaw extends ItemThaumiumChainsaw {

    boolean alternateServer;
    boolean alternateClient;
    @SuppressWarnings("rawtypes")
    public static ArrayList oreDictLogs = new ArrayList();

    public ItemStreamChainsaw() {
        this.efficiency = 25F;
        alternateServer = false;
        alternateClient = false;
        setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        this.maxStackSize = 1;
        this.setMaxDamage(27);
        maxCharge = 900000;
        cost = 400;
        hitCost = 500;
        tier = 3;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.BOW;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
        List<EntityItem> stuff = EntityUtils.getEntitiesInRange(player.world, player.posX, player.posY, player.posZ, player, EntityItem.class, 10.0);
        if (stuff != null && stuff.size() > 0) {
            for (EntityItem e : stuff) {
                if (!e.isDead) {
                    double d6 = e.posX - player.posX;
                    double d7 = e.posY - player.posY + player.height / 2.0f;
                    double d8 = e.posZ - player.posZ;
                    double d9 = MathHelper.sqrt(d6 * d6 + d7 * d7 + d8 * d8);
                    d6 /= d9;
                    d7 /= d9;
                    d8 /= d9;
                    double d10 = 0.3;
                    EntityItem entityItem = e;
                    entityItem.motionX -= d6 * d10;
                    EntityItem entityItem2 = e;
                    entityItem2.motionY -= d7 * d10 - 0.1;
                    EntityItem entityItem3 = e;
                    entityItem3.motionZ -= d8 * d10;
                    if (e.motionX > 0.25) {
                        e.motionX = 0.25;
                    }
                    if (e.motionX < -0.25) {
                        e.motionX = -0.25;
                    }
                    if (e.motionY > 0.25) {
                        e.motionY = 0.25;
                    }
                    if (e.motionY < -0.25) {
                        e.motionY = -0.25;
                    }
                    if (e.motionZ > 0.25) {
                        e.motionZ = 0.25;
                    }
                    if (e.motionZ < -0.25) {
                        e.motionZ = -0.25;
                    }
                    if (!player.world.isRemote) {
                        continue;
                    }
                    FXDispatcher.INSTANCE.crucibleBubble((float) e.posX + (player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.2f, (float) e.posY + e.height + (player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.2f, (float) e.posZ + (player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.2f, 0.33f, 0.33f, 1.0f);
                }
            }
        }
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == EMTCreativeTabs.EMT_CREATIVEtabs || tab == CreativeTabs.SEARCH) {
            ItemStack w1 = new ItemStack(this);
            EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.BURROWING, 1);
            EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.COLLECTOR, 1);
            items.add(w1);
        } else {
            super.getSubItems(tab, items);
        }
    }

    /* IC2 API METHODS */
    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return 900;
    }
}