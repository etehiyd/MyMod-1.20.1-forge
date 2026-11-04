package com.etehiyd.mymod.datagen;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.block.ModBlocks;
import com.etehiyd.mymod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsLanguageProvider extends LanguageProvider {
    public ModEnUsLanguageProvider(PackOutput output) {
        super(output, MyMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.NETHER_ASH.get(), "Nether Ash");
        add(ModItems.LEAD_INGOT.get(), "Lead Ingot");
        add(ModItems.LEAD_NUGGET.get(), "Lead Nugget");
        add(ModItems.RAW_LEAD.get(), "Raw Lead");

        add(ModBlocks.LEAD_BLOCK.get(), "Lead Block");
        add(ModBlocks.RAW_LEAD_BLOCK.get(), "Raw Lead Block");
        add(ModBlocks.LEAD_ORE.get(), "Lead Ore");
        add(ModBlocks.DEEPSLATE_LEAD_ORE.get(), "Deepslate Lead Ore");
        add(ModBlocks.NETHER_ASH_BLOCK.get(), "Nether Ash Block");

        add("itemGroup.my_tab", "My Items");
        add("itemGroup.my_blocks", "My Blocks");
    }
}
