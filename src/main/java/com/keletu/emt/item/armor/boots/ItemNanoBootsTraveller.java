package com.keletu.emt.item.armor.boots;


import com.keletu.emt.ElectroMagicTools;
import com.keletu.emt.util.EMTConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class ItemNanoBootsTraveller extends ItemElectricBootsTraveller {
    public ItemNanoBootsTraveller(int par3) {
        super(par3);
        maxCharge = 1000000;
        speedBonus = (float) EMTConfigHandler.nanoBootsSpeedBust;
        jumpBonus = (float) EMTConfigHandler.nanoBootsJumpBust;
        visDiscount = 4;
        transferLimit = 1000;
        energyPerDamage = 500;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return ElectroMagicTools.TEXTURE_PATH + ":textures/models/armor/nanobootstravel.png";
    }



}
