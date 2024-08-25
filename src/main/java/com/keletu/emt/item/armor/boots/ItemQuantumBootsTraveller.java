package com.keletu.emt.item.armor.boots;

import com.keletu.emt.ElectroMagicTools;
import com.keletu.emt.util.EMTConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class ItemQuantumBootsTraveller extends ItemElectricBootsTraveller{

    public ItemQuantumBootsTraveller(int renderIndexIn) {
        super(renderIndexIn);
        maxCharge = 10000000;
        speedBonus = (float) EMTConfigHandler.quantumBootsSpeedBust;
        jumpBonus = (float) EMTConfigHandler.quantumBootsJumpBust;
        visDiscount = 5;
        transferLimit = 10000;
        energyPerDamage = 1000;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return ElectroMagicTools.TEXTURE_PATH + ":textures/models/armor/quantumbootstravel.png";
    }


}
