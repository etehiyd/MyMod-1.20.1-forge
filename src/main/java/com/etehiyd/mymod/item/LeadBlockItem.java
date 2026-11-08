package com.etehiyd.mymod.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class LeadBlockItem extends EatableBlockItem {
    public LeadBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity){
        ItemStack result = super.finishUsingItem(stack, level, entity);
        if(!level.isClientSide && entity instanceof ServerPlayer player){
            player.hurt(level.damageSources().genericKill(), Float.MAX_VALUE);
        }
        return result;
    }
}
