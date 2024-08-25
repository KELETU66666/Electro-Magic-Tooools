package com.keletu.emt.item.armor.wings;

import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.client.model.ModelWings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemFeatherWing extends ItemArmor {

    public int visDiscount = 0;

    public ItemFeatherWing(ArmorMaterial material, int par3, EntityEquipmentSlot par4) {
        super(material, par3, par4);
        this.setMaxStackSize(1);
        this.setMaxDamage(120);
        this.setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        this.isDamageable();
    }

    @Nullable
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        try {
            if (entityLiving instanceof EntityPlayer) {
                ModelWings mw = new ModelWings();
                assert itemStack.getTagCompound() != null;
                mw.isJumping = itemStack.getTagCompound().getBoolean("isJumping");
                return mw;
            }
        } catch (NullPointerException e) {
            return new ModelWings();
        }
        return new ModelWings();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) {
            boolean isJumping = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isHoldingJump = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isSneaking = Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed();

            if (isJumping) player.motionY = 0.25;

            if (isHoldingJump && !player.onGround && player.motionY < 0 && !player.capabilities.isCreativeMode)
                player.motionY *= 0.9;

            if (player.isInWater() && !player.capabilities.isCreativeMode) player.motionY = -0.6;

            if ((player.world.isRaining() || player.world.isThundering()) && !player.capabilities.isCreativeMode)
                player.motionY = -0.3;

            if (isSneaking && !player.onGround) player.motionY = -0.6;
        }
        if (player.fallDistance > 0.0F) player.fallDistance = 0;
    }
}