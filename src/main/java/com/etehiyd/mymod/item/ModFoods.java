package com.etehiyd.mymod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties LEAD_NUGGET = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 400), 0.5F)
            .build();

    public static final FoodProperties LEAD_INGOT = new FoodProperties.Builder()
            .nutrition(9)
            .saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 1200), 0.8F)
            .build();
}
