package com.etehiyd.mymod.datagen;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.block.ModBlocks;
import com.etehiyd.mymod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModZhCnLanguageProvider extends LanguageProvider {
    public ModZhCnLanguageProvider(PackOutput output) {
        super(output, MyMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.NETHER_ASH.get(), "下界灰烬");
        add(ModItems.LEAD_INGOT.get(), "铅锭");
        add(ModItems.LEAD_NUGGET.get(), "铅粒");
        add(ModItems.RAW_LEAD.get(), "粗铅");

        add(ModBlocks.LEAD_BLOCK.get(), "铅块");
        add(ModBlocks.RAW_LEAD_BLOCK.get(), "粗铅块");
        add(ModBlocks.LEAD_ORE.get(), "铅矿石");
        add(ModBlocks.DEEPSLATE_LEAD_ORE.get(), "深层铅矿石");
        add(ModBlocks.NETHER_ASH_BLOCK.get(), "下界灰烬快");

        add("itemGroup.my_tab", "自用物品");
        add("itemGroup.my_blocks", "自用方块");
    }
}
