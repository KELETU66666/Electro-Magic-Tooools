package com.keletu.emt.item.armor.wings;

import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.ElectroMagicTools;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemQuantumWing  extends ItemNanoWing{
    public static int maxCharge = 10000000;
    public int tier = 4;

    public ItemQuantumWing(ArmorMaterial material, int par3, EntityEquipmentSlot par4) {
        super(material, par3, par4);
        this.setMaxStackSize(1);
        this.setMaxDamage(27);
        this.setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        maxCharge = 1000000;
        visDiscount = 6;
        transferLimit = 10000;
        energyPerDamage = 1000;
    }


    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return ElectroMagicTools.TEXTURE_PATH + ":textures/models/armor/quantumwing.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) {
            boolean isJumping = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isHoldingJump = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isSneaking = Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed();

            if (isJumping) player.motionY = 0.85;

            if (isHoldingJump && !player.onGround && player.motionY < 0 && !player.capabilities.isCreativeMode)
                player.motionY *= 0.3;

            if (player.isInWater() && !player.capabilities.isCreativeMode) player.motionY = -0.1;

            if ((player.world.isRaining() || player.world.isThundering()) && !player.capabilities.isCreativeMode)
                player.motionY = -0.05;

            if (isSneaking && isHoldingJump) player.motionY = 0;

            if (isSneaking && !player.onGround && !isHoldingJump) player.motionY = -0.6;
        }
        if (player.fallDistance > 0.0F) player.fallDistance = 0;
    }

    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return maxCharge;
    }
    @Override
    public int getTier(ItemStack itemStack) {
        return 4;
    }

    public double getDamageAbsorptionRatio() {
        return 1D;
    }
}
