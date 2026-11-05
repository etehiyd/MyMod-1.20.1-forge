package com.etehiyd.mymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> NETHER_LEAVES = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("my_mod", "nether_leaves")
    );

    public static final TagKey<Item> NETHER_GRASSES = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("my_mod", "nether_grasses")
    );
}
