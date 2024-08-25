package com.keletu.emt.item;

import com.keletu.emt.ElectroMagicTools;
import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.util.EMTTextHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemBase extends Item {

    public ItemBase(String unlocName, String textureName) {
        super();
        setTranslationKey(ElectroMagicTools.MOD_ID + unlocName);
        setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);


    }

    ItemBase(String unlocName) {
        super();
        setTranslationKey(ElectroMagicTools.MOD_ID + ".item." + unlocName);
       setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
    }

    public String getItemStackDisplayName(ItemStack stack) {
        return (EMTTextHelper.GREEN + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
}
