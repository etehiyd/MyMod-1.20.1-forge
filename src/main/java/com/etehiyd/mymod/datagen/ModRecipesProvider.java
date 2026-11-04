package com.etehiyd.mymod.datagen;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.block.ModBlocks;
import com.etehiyd.mymod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider {
    public ModRecipesProvider(PackOutput pOutput) {
        super(pOutput);
    }

    public static final List<ItemLike> LEAD_INGOT = List.of(ModItems.RAW_LEAD.get(), ModBlocks.LEAD_ORE.get(), ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModBlocks.NETHER_ASH_BLOCK.get());

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, LEAD_INGOT, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.7F, 200, "lead_ingot");
        oreBlasting(pWriter, LEAD_INGOT, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.7F, 100, "lead_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,  ModBlocks.LEAD_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.LEAD_INGOT.get())
                .unlockedBy(getHasName(ModItems.LEAD_INGOT.get()), has(ModItems.LEAD_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,  ModBlocks.RAW_LEAD_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_LEAD.get())
                .unlockedBy(getHasName(ModItems.RAW_LEAD.get()), has(ModItems.RAW_LEAD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,  ModBlocks.NETHER_ASH_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.NETHER_ASH.get())
                .unlockedBy(getHasName(ModItems.NETHER_ASH.get()), has(ModItems.NETHER_ASH.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,  ModItems.LEAD_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.LEAD_NUGGET.get())
                .unlockedBy(getHasName(ModItems.LEAD_NUGGET.get()), has(ModItems.LEAD_NUGGET.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 9)
                .requires(ModBlocks.LEAD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LEAD_BLOCK.get()), has(ModBlocks.LEAD_BLOCK.get()))
                .save(pWriter, MyMod.MOD_ID + ":" + "lead_ingot_from_lead_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_LEAD.get(), 9)
                .requires(ModBlocks.RAW_LEAD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_LEAD_BLOCK.get()), has(ModBlocks.RAW_LEAD_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHER_ASH.get(), 9)
                .requires(ModBlocks.NETHER_ASH_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NETHER_ASH_BLOCK.get()), has(ModBlocks.NETHER_ASH_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LEAD_NUGGET.get(), 9)
                .requires(ModItems.LEAD_INGOT.get())
                .unlockedBy(getHasName(ModItems.LEAD_INGOT.get()), has(ModItems.LEAD_INGOT.get()))
                .save(pWriter);

        /*nineBlockStorageRecipes(pWriter,
                RecipeCategory.MISC, ModItems.LEAD_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK.get());

        nineBlockStorageRecipes(pWriter,
                RecipeCategory.MISC, ModItems.LEAD_NUGGET.get(),
                RecipeCategory.MISC, ModItems.LEAD_INGOT.get());

        nineBlockStorageRecipes(pWriter,
                RecipeCategory.MISC, ModItems.RAW_LEAD.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_LEAD_BLOCK.get());

        nineBlockStorageRecipes(pWriter,
                RecipeCategory.MISC, ModItems.NETHER_ASH.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_ASH_BLOCK.get());*/
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
