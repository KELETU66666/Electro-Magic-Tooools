package com.keletu.emt.item.armor.wings;

import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.ElectroMagicTools;
import com.keletu.emt.util.EMTConfigHandler;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemNanoWing extends ItemThaumiumReinforcedWing implements IElectricItem, ISpecialArmor, IMetalArmor {

    public int maxCharge = 100000;
    public int tier = 3;
    public double transferLimit = 1000;
    public int energyPerDamage = 100;

    public ItemNanoWing(ArmorMaterial material, int par3, EntityEquipmentSlot par4) {
        super(material, par3, par4);
        this.setMaxStackSize(1);
        this.setMaxDamage(27);
        this.setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        visDiscount = 5;
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

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return ElectroMagicTools.TEXTURE_PATH + ":textures/models/armor/nanowing.png";

    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) {
            boolean isJumping = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isHoldingJump = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isSneaking = Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed();

            if (isJumping) player.motionY = 0.7;

            if (isHoldingJump && !player.onGround && player.motionY < 0 && !player.capabilities.isCreativeMode)
                player.motionY *= 0.3;

            if (player.isInWater() && !player.capabilities.isCreativeMode) player.motionY = -0.4;

            if ((player.world.isRaining() || player.world.isThundering()) && !player.capabilities.isCreativeMode)
                player.motionY = -0.2;

            if (isSneaking && !player.onGround) player.motionY = -0.6;
        }
        if (player.fallDistance > 0.0F) player.fallDistance = 0;
    }

    @Override
    public boolean isMetalArmor(ItemStack itemstack, EntityPlayer player) {
        return true;
    }

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
        if (EMTConfigHandler.enchanting == false) {
            return false;
        } else {
            return true;
        }
    }

    public int getEnergyPerDamage() {
        return energyPerDamage;
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        if (source.isUnblockable()) {
            return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(0, 0.0D, 3);
        } else {
            double absorptionRatio = getBaseAbsorptionRatio() * getDamageAbsorptionRatio();
            int energyPerDamage = getEnergyPerDamage();
            double damageLimit = energyPerDamage <= 0 ? 0 : (25 * ElectricItem.manager.getCharge(armor)) / energyPerDamage;
            return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(3, absorptionRatio, (int) damageLimit);
        }
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        if (ElectricItem.manager.getCharge(armor) >= getEnergyPerDamage()) {
            return (int) Math.round(20D * getBaseAbsorptionRatio() * getDamageAbsorptionRatio());
        } else {
            return 0;
        }
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
        ElectricItem.manager.discharge(stack, damage * getEnergyPerDamage(), 0x7fffffff, true, false, false);
    }

    public double getDamageAbsorptionRatio() {
        return 1.1000000000000001D;
    }

    private double getBaseAbsorptionRatio() {
        return 0.14999999999999999D;
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
        return 2;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return transferLimit;
    }
}