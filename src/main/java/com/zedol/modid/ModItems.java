package com.zedol.modid;


import net.minecraft.item.equipment.EquipmentAsset;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.entity.ApplyMobEffectEnchantmentEffect;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.tools.Tool;
import java.util.function.Function;
import static net.minecraft.entity.effect.StatusEffects.SLOWNESS;

public class ModItems {

    public static Item register(
            String name,
            Function<Item.Settings, Item> itemFactory,
            Item.Settings settings
    ) {
        // Create a unique registry key for this item.
        RegistryKey<Item> itemKey = RegistryKey.of(
                RegistryKeys.ITEM,
                Identifier.of(ZedolPack.MOD_ID, name)
        );

        // Create the item instance using the provided factory and settings.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item with Minecraft's item registry.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }


    public static void initialize() {
        // Called during mod initialization to register our items.
        // Get the event for modifying entries in the food and drink group.
        // And register an event handler that adds our bubble gum to the food and drink group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.BUBBLE_GUM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.DESTRUCTION_SWORD));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> itemGroup.add(ModItems.LIGHTNING_STICK));
    }


    public static final Item BUBBLE_GUM = register(
            "bubble_gum",
            Item::new,
            new Item.Settings().food(new FoodComponent.Builder().nutrition(3).saturationModifier(1).alwaysEdible().build(), ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 180 * 20, 2), 1.0f))
                    .build())
    );


    public static final Item DESTRUCTION_SWORD = register(
            "destruction_sword",
            destruction_sword::new,
            new Item.Settings().sword(ToolMaterial.NETHERITE, 7f, 1f).fireproof()

    );

    public static final Item LIGHTNING_STICK = register(
            "lightning_stick",
            lightning_stick::new,
            new Item.Settings()
    );


// TEST FOR AN ARMOR SET
    // CHESTPLATE LEGGINGS BOOTS HELMET


    public static final Item GUIDITE_CHESTPLATE = register(
            "guidite_chesplate",
            Item::new,
            new Item.Settings().armor(GuiditeArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)

    );


}



