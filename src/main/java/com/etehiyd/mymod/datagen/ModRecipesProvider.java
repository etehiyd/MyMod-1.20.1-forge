package com.etehiyd.mymod.datagen;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.block.ModBlocks;
import com.etehiyd.mymod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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

    public static final List<ItemLike> LEAD_ORES = List.of(ModItems.RAW_LEAD.get(), ModBlocks.LEAD_ORE.get(), ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModBlocks.NETHER_ASH_BLOCK.get());
    public static final List<ItemLike> NETHER_ASH = List.of(ModItems.NETHER_ASH.get());

    public static final TagKey<Item> NETHER_GRASSES = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("my_mod", "nether_grasses")
    );

    public static final TagKey<Item> NETHER_LEAVES = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("my_mod", "nether_leaves")
    );

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, LEAD_ORES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.7F, 200, "lead_ingot");
        oreBlasting(pWriter, LEAD_ORES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.7F, 100, "lead_ingot");

        oreSmelting(pWriter, NETHER_ASH, RecipeCategory.MISC, ModItems.LEAD_NUGGET.get(), 0.2F, 200, "lead_nugget");
        oreBlasting(pWriter, NETHER_ASH, RecipeCategory.MISC, ModItems.LEAD_NUGGET.get(), 0.2F, 100, "lead_nugget");

        oreSmelting(pWriter, NETHER_GRASSES, RecipeCategory.MISC, ModItems.NETHER_ASH.get(), 0.1F, 200, "nether_ash");
        oreBlasting(pWriter, NETHER_GRASSES, RecipeCategory.MISC, ModItems.NETHER_ASH.get(), 0.1F, 100, "nether_ash");

        oreSmelting(pWriter, NETHER_LEAVES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_ASH_BLOCK.get(), 0.2F, 200, "lead_block");
        oreBlasting(pWriter, NETHER_LEAVES, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_ASH_BLOCK.get(), 0.2F, 100, "lead_block");

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
                RecipeCategory.MISC, ModItems.LEAD_ORES.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK.get());

        nineBlockStorageRecipes(pWriter,
                RecipeCategory.MISC, ModItems.LEAD_NUGGET.get(),
                RecipeCategory.MISC, ModItems.LEAD_ORES.get());

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

    // 重载：原料为 tag
    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, TagKey<Item> tag, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, tag, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, TagKey<Item> tag, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, tag, category, result, experience, cookingTime, group, "_from_blasting");
    }

    // 重载：tag 版本
    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer, TagKey<Item> tag, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String suffix) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(tag), category, result, experience, cookingTime, serializer)
                .group(group)
                .unlockedBy(tag.location().getPath(), has(tag))
                .save(consumer, MyMod.MOD_ID + ":" + getItemName(result) + suffix + "_" + tag.location().getPath());
    }
}
