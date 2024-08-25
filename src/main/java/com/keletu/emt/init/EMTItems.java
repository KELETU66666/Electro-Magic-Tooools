package com.keletu.emt.init;

import com.keletu.emt.ElectroMagicTools;
import com.keletu.emt.client.creativetabs.EMTCreativeTabs;
import com.keletu.emt.item.ItemElectricScribingTools;
import com.keletu.emt.item.ItemIC2Baubles;
import com.keletu.emt.item.ItemMaterials;
import com.keletu.emt.item.ItemOneRing;
import com.keletu.emt.item.armor.boots.ItemElectricBootsTraveller;
import com.keletu.emt.item.armor.boots.ItemNanoBootsTraveller;
import com.keletu.emt.item.armor.boots.ItemQuantumBootsTraveller;
import com.keletu.emt.item.armor.googles.ItemElectricGoggles;
import com.keletu.emt.item.armor.googles.ItemNanoGoggles;
import com.keletu.emt.item.armor.googles.ItemQuantumGoggles;
import com.keletu.emt.item.armor.googles.ItemSolarHelmetRevealing;
import com.keletu.emt.item.armor.wings.ItemFeatherWing;
import com.keletu.emt.item.armor.wings.ItemNanoWing;
import com.keletu.emt.item.armor.wings.ItemQuantumWing;
import com.keletu.emt.item.armor.wings.ItemThaumiumReinforcedWing;
import com.keletu.emt.item.tool.*;
import joptsimple.internal.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import thaumcraft.api.ThaumcraftMaterials;

public class EMTItems {

    public static Item ironomnitool;
    public static Item diamondomnitool;
    public static Item thaumiumomnitool;
    public static Item featherwing;
    public static Item thaumiumwing;
    public static Item nanowing;
    public static Item quantumwing;
    public static Item thaumiumdrill;
    public static Item thaumiumchainsaw;
    public static Item diamondchainsaw;
    public static Item streamchainsaw;
    public static Item electrichoegrowth;
    public static Item thorhammer;
    public static Item rockbreakerdrill;

    public static Item taintedthorhammer;
    public static Item electricthorhammer;

    public static Item electricbootstraveller;
    public static Item nanobootstraveller;
    public static Item quantumbootstraveller;


    public static Item materials_oreclusteruranium;
    public static Item materials_crushedoreamber;
    public static Item materials_purifiedoreamber;
    public static Item materials_crushedorecinnabar;
    public static Item materials_purifiedorecinnabar;
    public static Item materials_lightningsummoner;
    public static Item materials_feathermesh;
    public static Item materials_glue;
    public static Item materials_ducttape;
    public static Item materials_rubberball;
    public static Item materials_cardboard;
    public static Item materials_feathergluedcardboardwing;
    public static Item materials_taintedfeather;
    public static Item materials_thaumiumwing;
    public static Item materials_uumatterdrop;

    public static Item electricgoggles;
    public static Item nanogoggles;
    public static Item quantumgoggles;
    public static Item solarhelmetrevealing;

    public static Item emtbaubles_armor;
    public static Item emtbaubles_inventory;
    public static Item electricscribingtools;

    public static Item onering;


    public static ItemArmor.ArmorMaterial featherWingMaterial = EnumHelper.addArmorMaterial("FEATEHRWiNG", "emt:featherwing", 10, new int[]{2, 2, 2, 2}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

    public static void init() {
        onering = new ItemOneRing().setTranslationKey("onering").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        ironomnitool = new ItemIronOmniTool().setTranslationKey("ironomnitool").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        diamondomnitool = new ItemDiamondOmniTool().setTranslationKey("diamondomnitool").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        thaumiumomnitool = new ItemThaumiumOmniTool().setTranslationKey("thaumiumomnitool").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        thaumiumdrill = new ItemThaumiumDrill().setTranslationKey("thaumiumdrill").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        thaumiumchainsaw = new ItemThaumiumChainsaw().setTranslationKey("thaumiumchainsaw").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        diamondchainsaw = new ItemDiamondChainsaw().setTranslationKey("diamondchainsaw").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        streamchainsaw = new ItemStreamChainsaw().setTranslationKey("streamchainsaw").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        electrichoegrowth = new ItemElectricHoeGrowth().setTranslationKey("electrichoegrowth").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        thorhammer = new ItemThorHammer().setTranslationKey("thorhammer").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        taintedthorhammer = new ItemThorHammerBroken().setTranslationKey("taintedthorhammer").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        electricthorhammer = new ItemElectricThorHammer().setTranslationKey("electricthorhammer").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        rockbreakerdrill = new ItemRockbreakerDrill().setTranslationKey("rockbreakerdrill").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        thaumiumwing = new ItemThaumiumReinforcedWing(ThaumcraftMaterials.ARMORMAT_THAUMIUM, 7, EntityEquipmentSlot.CHEST).setTranslationKey("thaumiumwing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        nanowing = new ItemNanoWing(ItemArmor.ArmorMaterial.DIAMOND, 7, EntityEquipmentSlot.CHEST).setTranslationKey("nanowing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        quantumwing = new ItemQuantumWing(ItemArmor.ArmorMaterial.DIAMOND, 7, EntityEquipmentSlot.CHEST).setTranslationKey("quantumwing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        featherwing = new ItemFeatherWing(featherWingMaterial, 7, EntityEquipmentSlot.CHEST).setTranslationKey("featherwing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        electricbootstraveller = new ItemElectricBootsTraveller(3).setTranslationKey("electricbootstraveller").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        nanobootstraveller = new ItemNanoBootsTraveller(3).setTranslationKey("nanobootsraveller").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        quantumbootstraveller = new ItemQuantumBootsTraveller(3).setTranslationKey("quantumbootsraveller").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);


        materials_oreclusteruranium = new ItemMaterials().setTranslationKey("materials_oreclusteruranium").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_crushedoreamber = new ItemMaterials().setTranslationKey("materials_crushedoreamber").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_purifiedoreamber = new ItemMaterials().setTranslationKey("materials_purifiedoreamber").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_crushedorecinnabar = new ItemMaterials().setTranslationKey("materials_crushedorecinnabar").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_purifiedorecinnabar = new ItemMaterials().setTranslationKey("materials_purifiedorecinnabar").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_lightningsummoner = new ItemMaterials().setTranslationKey("materials_lightningsummoner").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_feathermesh = new ItemMaterials().setTranslationKey("materials_feathermesh").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_glue = new ItemMaterials().setTranslationKey("materials_glue").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_ducttape = new ItemMaterials().setTranslationKey("materials_ducttape").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_rubberball = new ItemMaterials().setTranslationKey("materials_rubberball").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_cardboard = new ItemMaterials().setTranslationKey("materials_cardboard").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_feathergluedcardboardwing = new ItemMaterials().setTranslationKey("materials_feathergluedcardboardwing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_taintedfeather = new ItemMaterials().setTranslationKey("materials_taintedfeather").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_thaumiumwing = new ItemMaterials().setTranslationKey("materials_thaumiumwing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        materials_uumatterdrop = new ItemMaterials().setTranslationKey("materials_uumatterdrop").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        electricgoggles = new ItemElectricGoggles(ItemArmor.ArmorMaterial.IRON, 3, EntityEquipmentSlot.HEAD).setTranslationKey("electricgoggles").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        nanogoggles = new ItemNanoGoggles(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.HEAD).setTranslationKey("nanogoggles").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        quantumgoggles = new ItemQuantumGoggles(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.HEAD).setTranslationKey("quantumgoggles").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        solarhelmetrevealing = new ItemSolarHelmetRevealing(ItemArmor.ArmorMaterial.DIAMOND, 3, EntityEquipmentSlot.HEAD).setTranslationKey("solarhelmetrevealing").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);

        emtbaubles_armor = new ItemIC2Baubles().setTranslationKey("emtbaubles_armor").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        emtbaubles_inventory = new ItemIC2Baubles().setTranslationKey("emtbaubles_inventory").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
        electricscribingtools = new ItemElectricScribingTools().setTranslationKey("electricscribingtools").setCreativeTab(EMTCreativeTabs.EMT_CREATIVEtabs);
    }


    public static void InGameRegister() {
        EMTItems.registerItem(ironomnitool, ironomnitool.getTranslationKey().substring(5));
        EMTItems.registerItem(diamondomnitool, diamondomnitool.getTranslationKey().substring(5));
        EMTItems.registerItem(thaumiumomnitool, thaumiumomnitool.getTranslationKey().substring(5));
        EMTItems.registerItem(thaumiumdrill, thaumiumdrill.getTranslationKey().substring(5));
        EMTItems.registerItem(featherwing, featherwing.getTranslationKey().substring(5));
        EMTItems.registerItem(thaumiumchainsaw, thaumiumchainsaw.getTranslationKey().substring(5));
        EMTItems.registerItem(diamondchainsaw, diamondchainsaw.getTranslationKey().substring(5));
        EMTItems.registerItem(streamchainsaw, streamchainsaw.getTranslationKey().substring(5));
        EMTItems.registerItem(thaumiumwing, thaumiumwing.getTranslationKey().substring(5));
        EMTItems.registerItem(nanowing, nanowing.getTranslationKey().substring(5));
        EMTItems.registerItem(quantumwing, quantumwing.getTranslationKey().substring(5));
        EMTItems.registerItem(electrichoegrowth, electrichoegrowth.getTranslationKey().substring(5));
        EMTItems.registerItem(thorhammer, thorhammer.getTranslationKey().substring(5));
        EMTItems.registerItem(rockbreakerdrill, rockbreakerdrill.getTranslationKey().substring(5));
        EMTItems.registerItem(taintedthorhammer, taintedthorhammer.getTranslationKey().substring(5));
        EMTItems.registerItem(electricthorhammer, electricthorhammer.getTranslationKey().substring(5));

        EMTItems.registerItem(materials_oreclusteruranium, materials_oreclusteruranium.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_crushedoreamber, materials_crushedoreamber.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_purifiedoreamber, materials_purifiedoreamber.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_crushedorecinnabar, materials_crushedorecinnabar.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_purifiedorecinnabar, materials_purifiedorecinnabar.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_feathermesh, materials_feathermesh.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_glue, materials_glue.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_ducttape, materials_ducttape.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_rubberball, materials_rubberball.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_cardboard, materials_cardboard.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_feathergluedcardboardwing, materials_feathergluedcardboardwing.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_taintedfeather, materials_taintedfeather.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_thaumiumwing, materials_thaumiumwing.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_uumatterdrop, materials_uumatterdrop.getTranslationKey().substring(5));
        EMTItems.registerItem(materials_lightningsummoner, materials_lightningsummoner.getTranslationKey().substring(5));

        EMTItems.registerItem(electricbootstraveller, electricbootstraveller.getTranslationKey().substring(5));
        EMTItems.registerItem(nanobootstraveller, nanobootstraveller.getTranslationKey().substring(5));
        EMTItems.registerItem(quantumbootstraveller, quantumbootstraveller.getTranslationKey().substring(5));

        EMTItems.registerItem(electricgoggles, electricgoggles.getTranslationKey().substring(5));
        EMTItems.registerItem(nanogoggles, nanogoggles.getTranslationKey().substring(5));
        EMTItems.registerItem(quantumgoggles, quantumgoggles.getTranslationKey().substring(5));
        EMTItems.registerItem(solarhelmetrevealing, solarhelmetrevealing.getTranslationKey().substring(5));
        EMTItems.registerItem(emtbaubles_armor, emtbaubles_armor.getTranslationKey().substring(5));
        EMTItems.registerItem(emtbaubles_inventory, emtbaubles_inventory.getTranslationKey().substring(5));
        EMTItems.registerItem(electricscribingtools, electricscribingtools.getTranslationKey().substring(5));
        EMTItems.registerItem(onering, onering.getTranslationKey().substring(5));

    }

    @Deprecated
    public static void registerItem(Item item, String name) {
        if (item.getRegistryName() == null && Strings.isNullOrEmpty(name))
            throw new IllegalArgumentException("Attempted to register a item with no name: " + item);

        ForgeRegistries.ITEMS.register(item.getRegistryName() == null ? item.setRegistryName(name) : item);
    }

    public static void Renders() {

        renderItems(ironomnitool);
        renderItems(diamondomnitool);
        renderItems(thaumiumomnitool);
        renderItems(thaumiumdrill);
        renderItems(thaumiumchainsaw);
        renderItems(diamondchainsaw);
        renderItems(streamchainsaw);
        renderItems(featherwing);
        renderItems(quantumwing);
        renderItems(thaumiumwing);
        renderItems(nanowing);
        renderItems(electrichoegrowth);
        renderItems(thorhammer);
        renderItems(rockbreakerdrill);
        renderItems(taintedthorhammer);
        renderItems(electricthorhammer);
        renderItems(materials_oreclusteruranium);
        renderItems(materials_crushedoreamber);
        renderItems(materials_purifiedoreamber);
        renderItems(materials_crushedorecinnabar);
        renderItems(materials_purifiedorecinnabar);
        renderItems(materials_feathermesh);
        renderItems(materials_glue);
        renderItems(materials_ducttape);
        renderItems(materials_rubberball);
        renderItems(materials_cardboard);
        renderItems(materials_feathergluedcardboardwing);
        renderItems(materials_taintedfeather);
        renderItems(materials_thaumiumwing);
        renderItems(materials_uumatterdrop);
        renderItems(materials_lightningsummoner);
        renderItems(electricbootstraveller);
        renderItems(nanobootstraveller);
        renderItems(quantumbootstraveller);
        renderItems(electricgoggles);
        renderItems(nanogoggles);
        renderItems(quantumgoggles);
        renderItems(solarhelmetrevealing);
        renderItems(emtbaubles_armor);
        renderItems(emtbaubles_inventory);
        renderItems(electricscribingtools);
        renderItems(onering);


    }


    public static void renderItems(Item i) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(
                ElectroMagicTools.MOD_ID + ":" + i.getTranslationKey().substring(5), "inventory"));
    }

}
