package com.keletu.emt.util;

import com.keletu.emt.init.EMTBlocks;
import com.keletu.emt.init.EMTItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;

public class EMTThauminiconsRecipes {

    static ResourceLocation defaultGroup = new ResourceLocation("");

    public static void setup() {
        ResearchCategories.registerCategory(catName, "", null, icon, back, back2);

        //===Arcane Recipe===\\
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("EMT.TaintFeather"), new ShapedArcaneRecipe(defaultGroup, "", 25, new AspectList()
                .add(primals(1)), new ItemStack(EMTItems.materials_thaumiumwing), "fti",
                "fti",
                "fti",

                't', "plateThaumium",
                'f', new ItemStack(EMTItems.materials_taintedfeather),
                'i', "plateIron"));


        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("EMT.electroST"), new ShapedArcaneRecipe(defaultGroup, "", 50, new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2).add(Aspect.ENTROPY, 2), new ItemStack(EMTItems.electricscribingtools),
                "ctc",
                "tet",
                "ctc",
                'c', "circuitBasic",
                't', new ItemStack(ItemsTC.scribingTools),
                'e', new ItemStack(Item.getByNameOrId("ic2:energy_crystal"), 1, OreDictionary.WILDCARD_VALUE)));

        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("EMT.diamondomnitool"), new ShapedArcaneRecipe(defaultGroup, "", 100, new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2), new ItemStack(EMTItems.diamondomnitool),
                "dad",
                "did",
                "dad",
                'a', "circuitAdvanced",
                'd', new ItemStack(Items.DIAMOND),
                'i', new ItemStack(EMTItems.ironomnitool)));

        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("EMT.electricgoggles"), new ShapedArcaneRecipe(defaultGroup, "", 150, new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2).add(Aspect.WATER, 2), new ItemStack(EMTItems.electricgoggles),
                " h ",
                "rgr",
                "cbc",
                'r', new ItemStack(Item.getByNameOrId("ic2:re_battery"), 1, OreDictionary.WILDCARD_VALUE),
                'b', "circuitBasic",
                'h', new ItemStack(Items.DIAMOND_HELMET),
                'g', new ItemStack(ItemsTC.goggles),
                'c', new ItemStack(Items.COMPARATOR)));

        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(""), new ShapedArcaneRecipe(defaultGroup, "", 200, new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2).add(Aspect.WATER, 2), new ItemStack(EMTBlocks.solar_compressed),
                "sss",
                "sss",
                "sss",
                's', new ItemStack(Item.getByNameOrId("ic2:te"), 1, 8)));
        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("_double"), new ShapedArcaneRecipe(defaultGroup, "", 200, new AspectList().add(Aspect.AIR, 2).add(Aspect.ORDER, 2).add(Aspect.WATER, 2), new ItemStack(EMTBlocks.solar_doublecompressed),
                "ccc",
                "ccc",
                "ccc",
                'c', new ItemStack(EMTBlocks.solar_compressed)));

        CrucibleRecipe solarAir = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_aircompressed), new ItemStack(EMTBlocks.solar_compressed), new AspectList().add(Aspect.AIR, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("Air"), solarAir);
        CrucibleRecipe solarDAir = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_airdoublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new AspectList().add(Aspect.AIR, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("DAir"), solarDAir);
        CrucibleRecipe solarTAir = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_airtriplecompressed), new ItemStack(EMTBlocks.solar_triplecompressed), new AspectList().add(Aspect.AIR, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("TAir"), solarTAir);

        CrucibleRecipe gAir = new CrucibleRecipe("", new ItemStack(EMTBlocks.aer_generator), new ItemStack(EMTBlocks.energy_generator), new AspectList().add(Aspect.AIR, 75).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("EMT.gAir"), gAir);
        CrucibleRecipe gAur = new CrucibleRecipe("", new ItemStack(EMTBlocks.auram_generator), new ItemStack(EMTBlocks.energy_generator), new AspectList().add(Aspect.AURA, 75).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("EMT.gAur"), gAur);
        CrucibleRecipe gIgnis = new CrucibleRecipe("", new ItemStack(EMTBlocks.fire_generator), new ItemStack(EMTBlocks.energy_generator), new AspectList().add(Aspect.FIRE, 75).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("EMT.gIgnis"), gIgnis);

        CrucibleRecipe solarE = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_earthcompressed), new ItemStack(EMTBlocks.solar_compressed), new AspectList().add(Aspect.EARTH, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("E"), solarE);
        CrucibleRecipe solarDE = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_earthdoublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new AspectList().add(Aspect.EARTH, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("DE"), solarDE);
        CrucibleRecipe solarTE = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_earthtriplecompressed), new ItemStack(EMTBlocks.solar_triplecompressed), new AspectList().add(Aspect.EARTH, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("TE"), solarTE);

        CrucibleRecipe solarEn = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_darkcompressed), new ItemStack(EMTBlocks.solar_compressed), new AspectList().add(Aspect.ENTROPY, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("En"), solarEn);
        CrucibleRecipe solarDEn = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_darkdoublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new AspectList().add(Aspect.ENTROPY, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("DEn"), solarDEn);
        CrucibleRecipe solarTEn = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_darktriplecompressed), new ItemStack(EMTBlocks.solar_triplecompressed), new AspectList().add(Aspect.ENTROPY, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("TEn"), solarTEn);

        CrucibleRecipe solarF = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_firecompressed), new ItemStack(EMTBlocks.solar_compressed), new AspectList().add(Aspect.FIRE, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("F"), solarF);
        CrucibleRecipe solarDF = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_firedoublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new AspectList().add(Aspect.FIRE, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("DF"), solarDF);
        CrucibleRecipe solarTF = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_firetriplecompressed), new ItemStack(EMTBlocks.solar_triplecompressed), new AspectList().add(Aspect.FIRE, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("TF"), solarTF);

        CrucibleRecipe solarO = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_ordercompressed), new ItemStack(EMTBlocks.solar_compressed), new AspectList().add(Aspect.ORDER, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("O"), solarO);
        CrucibleRecipe solarDO = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_orderdoublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new AspectList().add(Aspect.ORDER, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("DO"), solarDO);
        CrucibleRecipe solarTO = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_ordertriplecompressed), new ItemStack(EMTBlocks.solar_triplecompressed), new AspectList().add(Aspect.ORDER, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("TO"), solarTO);

        CrucibleRecipe solarW = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_watercompressed), new ItemStack(EMTBlocks.solar_compressed), new AspectList().add(Aspect.WATER, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("W"), solarW);
        CrucibleRecipe solarDW = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_waterdoublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new AspectList().add(Aspect.WATER, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("DW"), solarDW);
        CrucibleRecipe solarTW = new CrucibleRecipe("", new ItemStack(EMTBlocks.solar_watertriplecompressed), new ItemStack(EMTBlocks.solar_triplecompressed), new AspectList().add(Aspect.WATER, 75).add(Aspect.MAGIC, 50).add(Aspect.EXCHANGE, 50));
        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("TW"), solarTW);


        //===Infusion Recipe===\\

        InfusionRecipe thauOmnitools = new InfusionRecipe("", new ItemStack(EMTItems.thaumiumomnitool), 3, new AspectList().add(Aspect.TOOL, 75).add(Aspect.ENERGY, 75).add(Aspect.AVERSION, 75), new ItemStack(EMTItems.thaumiumchainsaw), new ItemStack(EMTItems.thaumiumdrill), "plateThaumium", "plateThaumium", "plateThaumium", new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 15), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 6));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.tomni"), thauOmnitools);
        InfusionRecipe thaumChainsaw = new InfusionRecipe("", new ItemStack(EMTItems.thaumiumchainsaw), 3, new AspectList().add(Aspect.TOOL, 40).add(Aspect.ENERGY, 40).add(Aspect.AVERSION, 40), new ItemStack(EMTItems.diamondchainsaw), "plateThaumium", "plateThaumium", "plateThaumium", new ItemStack(Item.getByNameOrId("ic2:plate"), 1, 12), new ItemStack(Items.DIAMOND), new ItemStack(Items.DIAMOND));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.tchainsaw"), thaumChainsaw);


        ItemStack w1 = new ItemStack(EMTItems.streamchainsaw);
        EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.BURROWING, 1);
        EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.COLLECTOR, 1);
        InfusionRecipe streamChainsaw = new InfusionRecipe("", w1, 4, new AspectList().add(Aspect.TOOL, 100).add(Aspect.ENERGY, 150).add(Aspect.AVERSION, 40).add(Aspect.WATER, 100), new ItemStack(EMTItems.thaumiumchainsaw), new ItemStack(Items.WATER_BUCKET), new ItemStack(ItemsTC.elementalAxe), new ItemStack(BlocksTC.logGreatwood), new ItemStack(Item.getByNameOrId("ic2:lapotron_crystal"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), new ItemStack(Item.getByNameOrId("ic2:upgrade"), 1, 0));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.schainsaw"), streamChainsaw);

        InfusionRecipe thaumDrill = new InfusionRecipe("", new ItemStack(EMTItems.thaumiumdrill), 2, new AspectList().add(Aspect.TOOL, 40).add(Aspect.ENERGY, 40).add(Aspect.AVERSION, 40), new ItemStack(Item.getByNameOrId("ic2:diamond_drill"), 1, OreDictionary.WILDCARD_VALUE), "plateThaumium", "plateThaumium", "plateThaumium", new ItemStack(Item.getByNameOrId("ic2:plate"), 1, 12), new ItemStack(Items.DIAMOND), new ItemStack(Items.DIAMOND));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.tdrill"), thaumDrill);

        ItemStack w2 = new ItemStack(EMTItems.rockbreakerdrill);
        EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.REFINING, 1);
        EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.DESTRUCTIVE, 1);
        EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.SOUNDING, 2);
        InfusionRecipe rockDrill = new InfusionRecipe("", w2, 4, new AspectList().add(Aspect.TOOL, 100).add(Aspect.ENERGY, 150).add(Aspect.AVERSION, 40).add(Aspect.WATER, 100), new ItemStack(EMTItems.thaumiumdrill), new ItemStack(Items.FLINT_AND_STEEL), new ItemStack(Items.FIRE_CHARGE), new ItemStack(ItemsTC.elementalPick), new ItemStack(ItemsTC.elementalShovel), new ItemStack(Item.getByNameOrId("ic2:energy_crystal"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), new ItemStack(Item.getByNameOrId("ic2:upgrade"), 1, 0), new ItemStack(Item.getByNameOrId("ic2:resource"), 1, 11));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.rdrill"), rockDrill);

        InfusionRecipe eHoG = new InfusionRecipe("", new ItemStack(EMTItems.electrichoegrowth), 2, new AspectList().add(Aspect.TOOL, 100).add(Aspect.ENERGY, 150).add(Aspect.AVERSION, 40).add(Aspect.WATER, 100).add(Aspect.PLANT, 75), new ItemStack(ItemsTC.elementalHoe), new ItemStack(Item.getByNameOrId("ic2:lapotron_crystal"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.getByNameOrId("ic2:electric_hoe")), new ItemStack(Items.DYE, 1, 15), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 6), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 5), new ItemStack(Blocks.SAPLING, 1, 0));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.ehor"), eHoG);


        InfusionRecipe electricBOT = new InfusionRecipe("", new ItemStack(EMTItems.electricbootstraveller), 2, new AspectList().add(Aspect.ENERGY, 50).add(Aspect.ORDER, 50).add(Aspect.MOTION, 100), new ItemStack(ItemsTC.travellerBoots), new ItemStack(Items.DIAMOND), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 6), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 5), new ItemStack(Item.getByNameOrId("ic2:rubber_boots")), new ItemStack(Item.getByNameOrId("ic2:advanced_re_battery"), 1, OreDictionary.WILDCARD_VALUE));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.ebot"), electricBOT);


        InfusionRecipe nanoW = new InfusionRecipe("", new ItemStack(EMTItems.nanowing), 2, new AspectList().add(Aspect.ENERGY, 100).add(Aspect.ORDER, 100).add(Aspect.MOTION, 100).add(Aspect.MECHANISM, 56), new ItemStack(EMTItems.thaumiumwing), new ItemStack(Items.DIAMOND), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 15), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 15), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 15), new ItemStack(Item.getByNameOrId("ic2:nano_chestplate"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemsTC.salisMundus));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.nanoW"), nanoW);
        InfusionRecipe nanoBOT = new InfusionRecipe("", new ItemStack(EMTItems.nanobootstraveller), 3, new AspectList().add(Aspect.ENERGY, 75).add(Aspect.ORDER, 40).add(Aspect.MOTION, 60), new ItemStack(EMTItems.electricbootstraveller), new ItemStack(Items.DIAMOND), new ItemStack(Item.getByNameOrId("ic2:nano_boots"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.getByNameOrId("ic2:energy_crystal"), 1, OreDictionary.WILDCARD_VALUE));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.nanoBOT"), nanoBOT);
        InfusionRecipe nanoGOR = new InfusionRecipe("", new ItemStack(EMTItems.nanogoggles), 3, new AspectList().add(Aspect.ENERGY, 60).add(Aspect.ORDER, 40).add(Aspect.SENSES, 50), new ItemStack(EMTItems.electricgoggles), new ItemStack(Items.DIAMOND), new ItemStack(Item.getByNameOrId("ic2:nano_helmet"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.GOLD_INGOT), "plateThaumium", new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 15), "circuitBasic");
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.nanoGOR"), nanoGOR);

        InfusionRecipe qW = new InfusionRecipe("", new ItemStack(EMTItems.quantumwing), 4, new AspectList().add(Aspect.ENERGY, 100).add(Aspect.ORDER, 100).add(Aspect.MOTION, 100).add(Aspect.MECHANISM, 56).add(Aspect.AIR, 100), new ItemStack(EMTItems.nanowing), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), new ItemStack(Item.getByNameOrId("ic2:quantum_chestplate"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ItemsTC.salisMundus));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.qW"), qW);
        InfusionRecipe qBOT = new InfusionRecipe("", new ItemStack(EMTItems.quantumbootstraveller), 4, new AspectList().add(Aspect.ENERGY, 100).add(Aspect.ORDER, 100).add(Aspect.MOTION, 100).add(Aspect.SENSES, 75).add(Aspect.AIR, 100), new ItemStack(EMTItems.nanobootstraveller), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Item.getByNameOrId("ic2:quantum_boots"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Item.getByNameOrId("ic2:lapotron_crystal"), 1, OreDictionary.WILDCARD_VALUE));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.qBOT"), qBOT);
        InfusionRecipe qGOR = new InfusionRecipe("", new ItemStack(EMTItems.quantumgoggles), 4, new AspectList().add(Aspect.ENERGY, 60).add(Aspect.ORDER, 40).add(Aspect.SENSES, 50), new ItemStack(EMTItems.nanogoggles), new ItemStack(Items.DIAMOND), new ItemStack(Item.getByNameOrId("ic2:quantum_helmet"), 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.MILK_BUCKET), "plateThaumium", "plateThaumium", new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 4), "circuitAdvanced");
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.qGOR"), qGOR);


        InfusionRecipe triple_solar = new InfusionRecipe("", new ItemStack(EMTBlocks.solar_triplecompressed), 4, new AspectList().add(primals(30)), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed), new ItemStack(EMTBlocks.solar_doublecompressed));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("_triple"), triple_solar);


        InfusionRecipe pot_generator = new InfusionRecipe("", new ItemStack(EMTBlocks.energy_generator), 5, new AspectList().add(Aspect.ENERGY, 200).add(Aspect.MAGIC, 200).add(Aspect.METAL, 200).add(Aspect.EXCHANGE, 200).add(Aspect.MECHANISM, 150), new ItemStack(Item.getByNameOrId("ic2:te"), 1, 7), new ItemStack(Items.DIAMOND), new ItemStack(BlocksTC.jarNormal), new ItemStack(Blocks.HOPPER), new ItemStack(Item.getByNameOrId("ic2:te"), 1, 78), new ItemStack(Item.getByNameOrId("ic2:te"), 1, 56), new ItemStack(Item.getByNameOrId("ic2:crafting"), 1, 23), new ItemStack(Item.getByNameOrId("ic2:resource"), 1, 13));
        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("EMT.potentia_generator"), pot_generator);
    }

    public static AspectList primals(int amount) {
        return new AspectList().add(Aspect.AIR, amount).add(Aspect.WATER, amount).add(Aspect.EARTH, amount).add(Aspect.FIRE, amount).add(Aspect.ORDER, amount).add(Aspect.ENTROPY, amount);
    }

    public static final String catName = "EMT";
    public static final ResourceLocation icon = new ResourceLocation("emt", "textures/misc/emt.png");
    public static final ResourceLocation back = new ResourceLocation("emt", "textures/misc/background.png");
    public static final ResourceLocation back2 = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");

}
