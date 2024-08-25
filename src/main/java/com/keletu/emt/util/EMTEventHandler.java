package com.keletu.emt.util;

import baubles.api.BaublesApi;

import com.keletu.emt.item.armor.wings.ItemFeatherWing;
import com.keletu.emt.init.EMTItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EMTEventHandler {
   
   @SubscribeEvent
   public void onPlayerTickEvent(TickEvent.PlayerTickEvent e){
       ItemStack is = e.player.inventory.armorInventory.get(2);
        if (is.getItem() instanceof ItemFeatherWing && e.phase == TickEvent.Phase.START && e.player.motionY > 0) {
            e.player.fallDistance -= e.player.motionY;
        }
   }

   @SubscribeEvent
   public void onSetEntityAttack(LivingSetAttackTargetEvent e){
       if(e.getEntityLiving()!=null&&e.getTarget()!=null&&e.getEntityLiving()instanceof EntityLiving && e.getTarget() instanceof EntityPlayer ){
           IInventory inventory = BaublesApi.getBaubles((EntityPlayer) e.getTarget());

           for(int i=0; i<inventory.getSizeInventory();i++){
               ItemStack stack = inventory.getStackInSlot(i);

               if(stack != ItemStack.EMPTY && stack.getItem()==EMTItems.onering){
                   ((EntityLiving) e.getEntityLiving()).setAttackTarget(null);
               }
           }
       }
   }

   @SubscribeEvent
   public void onEntityLivingDrop(LivingDropsEvent e){
        if (e.getEntityLiving() instanceof EntityCreeper) {
            EntityCreeper creeper = (EntityCreeper) e.getEntityLiving();
            if (creeper.getPowered()) {
                e.getEntityLiving().dropItem(EMTItems.materials_lightningsummoner, 1);
           }
         }
    }
}
