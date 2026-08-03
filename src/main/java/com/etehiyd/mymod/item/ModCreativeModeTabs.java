package com.etehiyd.mymod.item;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,  MyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MY_TAB =
            CREATIVE_MODE_TABS.register("my_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_LEAD.get()))
                    .title(Component.translatable("itemGroup.my_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LEAD_INGOT.get());
                        pOutput.accept(ModItems.LEAD_NUGGET.get());
                        pOutput.accept(ModItems.NETHER_ASH.get());
                        pOutput.accept(ModItems.RAW_LEAD.get());
                    })
                    .build()
            );

    public static final RegistryObject<CreativeModeTab> MY_BLOCKS =
            CREATIVE_MODE_TABS.register("my_blocks", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.LEAD_BLOCK.get()))
                    .title(Component.translatable("itemGroup.my_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.LEAD_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_LEAD_BLOCK.get());
                        pOutput.accept(ModBlocks.NETHER_ASH_BLOCK.get());
                        pOutput.accept(ModBlocks.LEAD_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_LEAD_ORE.get());
                    })
                    .withTabsBefore(MY_TAB.getKey())
                    .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
