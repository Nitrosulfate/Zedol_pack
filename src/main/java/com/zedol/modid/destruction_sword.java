package com.zedol.modid;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class destruction_sword extends Item {
    public destruction_sword(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1)); // 100 ticks of poison
        target.setOnFireFor(5);
    }
}
