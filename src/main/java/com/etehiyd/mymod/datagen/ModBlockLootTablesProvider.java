package com.etehiyd.mymod.datagen;

import com.etehiyd.mymod.block.ModBlocks;
import com.etehiyd.mymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    protected ModBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected LootTable.Builder createCopperOreLikeDrops(Block pBlock, Item item, float pMin,  float pMax) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(pMin, pMax)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LEAD_BLOCK.get());
        dropSelf(ModBlocks.NETHER_ASH_BLOCK.get());
        dropSelf(ModBlocks.RAW_LEAD_BLOCK.get());
        add(ModBlocks.LEAD_ORE.get(), block -> createCopperOreLikeDrops(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get(), 1.0F, 5.0F));
        add(ModBlocks.DEEPSLATE_LEAD_ORE.get(), block -> createCopperOreLikeDrops(ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModItems.RAW_LEAD.get(), 1.0F, 5.0F));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
