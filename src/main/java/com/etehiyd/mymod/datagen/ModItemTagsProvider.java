package com.etehiyd.mymod.datagen;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.item.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModItemTags.NETHER_LEAVES)
                .add(Items.NETHER_WART_BLOCK)
                .add(Items.WARPED_WART_BLOCK)
                .add(Items.SHROOMLIGHT);

        tag(ModItemTags.NETHER_GRASSES)
                .add(Items.CRIMSON_FUNGUS)
                .add(Items.WARPED_FUNGUS)
                .add(Items.CRIMSON_ROOTS)
                .add(Items.WARPED_ROOTS)
                .add(Items.TWISTING_VINES)
                .add(Items.WEEPING_VINES)
                .add(Items.NETHER_SPROUTS)
                .add(Items.NETHER_WART);
    }
}
