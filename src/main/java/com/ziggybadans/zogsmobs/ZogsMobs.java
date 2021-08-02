package com.ziggybadans.zogsmobs;

import com.ziggybadans.zogsmobs.entity.SnailEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ZogsMobs implements ModInitializer {

    public static final EntityType<SnailEntity> SNAIL = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("zogsmobs", "snail"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnailEntity::new).dimensions(EntityDimensions.fixed(0.75f,0.75f))
                    .build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(SNAIL, SnailEntity.createMobAttributes());

        Registry.register(Registry.ITEM, new Identifier("zogsmobs", "snail_spawn_egg"),
                new SpawnEggItem(SNAIL, 0x947968, 0xf0edca, new Item.Settings().group(ItemGroup.MISC)));

        SpawnInit.init();
    }
}
