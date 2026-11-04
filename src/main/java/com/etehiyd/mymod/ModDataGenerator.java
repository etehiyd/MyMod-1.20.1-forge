package com.etehiyd.mymod;

import com.etehiyd.mymod.datagen.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutPut = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipesProvider(packOutPut));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutPut));

        BlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(), new ModBlockTagsProvider(packOutPut, lookupProvider,  existingFileHelper));

        generator.addProvider(event.includeServer(), new ModItemTagsProvider(packOutPut, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutPut, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelsProvider(packOutPut, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModEnUsLanguageProvider(packOutPut));
        generator.addProvider(event.includeClient(), new ModZhCnLanguageProvider(packOutPut));
    }
}
