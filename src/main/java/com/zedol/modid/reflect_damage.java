package com.zedol.modid;


import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class reflect_damage implements ModInitializer {
    @Override
    public void onInitialize() {

    }

    // Method to reflect damage
    public static void reflectDamage(ServerWorld world, DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity attacker) {

            // Calculate the amount of damage to reflect
            float reflectAmount = amount * 0.50f;
            attacker.damage(world, source, reflectAmount);
        }
    }
}
