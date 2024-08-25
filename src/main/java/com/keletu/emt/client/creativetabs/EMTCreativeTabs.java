package com.keletu.emt.client.creativetabs;


import com.keletu.emt.init.EMTItems;
import com.keletu.emt.ElectroMagicTools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class EMTCreativeTabs extends CreativeTabs {
    public static EMTCreativeTabs EMT_CREATIVEtabs = new EMTCreativeTabs();

    public EMTCreativeTabs() {
        super(ElectroMagicTools.MOD_ID);
        setBackgroundImageName("emt.png");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(EMTItems.ironomnitool);
    }


    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> itemStacks) {
        super.displayAllRelevantItems(itemStacks);
    }
}
