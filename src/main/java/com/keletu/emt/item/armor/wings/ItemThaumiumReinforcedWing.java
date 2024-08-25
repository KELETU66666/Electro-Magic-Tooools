package com.keletu.emt.item.armor.wings;

import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.ElectroMagicTools;
import com.keletu.emt.util.EMTTextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.items.IVisDiscountGear;

import javax.annotation.Nullable;
import java.util.List;

public class ItemThaumiumReinforcedWing extends ItemFeatherWing implements IVisDiscountGear {
    int visDiscount;

    public ItemThaumiumReinforcedWing(ArmorMaterial material, int par3, EntityEquipmentSlot equipmentSlotIn) {
        super(material, par3, equipmentSlotIn);
        this.setMaxStackSize(1);
        this.setMaxDamage(250);
        this.setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        this.isDamageable();
        visDiscount = 4;
    }

    @Override
    public int getVisDiscount(ItemStack itemStack, EntityPlayer entityPlayer) {
        return visDiscount;
    }


    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return ElectroMagicTools.TEXTURE_PATH + ":textures/models/armor/thaumiumwing.png";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        if (world.isRemote) {
            boolean isJumping = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isHoldingJump = Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed();
            boolean isSneaking = Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed();

            if (isJumping) player.motionY = 0.5;

            if (isHoldingJump && !player.onGround && player.motionY < 0 && !player.capabilities.isCreativeMode)
                player.motionY *= 0.5;

            if (player.isInWater() && !player.capabilities.isCreativeMode) player.motionY = -0.6;

            if ((player.world.isRaining() || player.world.isThundering()) && !player.capabilities.isCreativeMode)
                player.motionY = -0.3;

            if (isSneaking && !player.onGround) player.motionY = -0.6;

        }
        if (player.fallDistance > 0.0F) player.fallDistance = 0;
    }
}
