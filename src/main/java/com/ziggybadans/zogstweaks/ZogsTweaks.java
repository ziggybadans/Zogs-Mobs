package com.ziggybadans.zogstweaks;

import com.ziggybadans.zogstweaks.entity.SnailEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ZogsTweaks implements ModInitializer {

    public static final String MOD_ID = "zogstweaks";

    // Creative Tabs
    public static final ItemGroup MAIN = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main"),
            () -> new ItemStack(ZogsTweaks.SNAIL_JAR));

    // Entities
    public static final EntityType<SnailEntity> SNAIL = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MOD_ID, "snail"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnailEntity::new).dimensions(EntityDimensions.fixed(0.75f,0.75f))
                    .build()
    );

    // Blocks
    public static final StairsBlock CRACKED_STONE_BRICK_STAIRS = new ModStairsBlock(Blocks.CRACKED_STONE_BRICKS.getDefaultState(),
            FabricBlockSettings.copy(Blocks.CRACKED_STONE_BRICKS));
    public static final SlabBlock CRACKED_STONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copy(Blocks.CRACKED_STONE_BRICKS));

    // Items
    public static final Item SNAIL_JAR = new Item(new FabricItemSettings().group(MAIN).maxCount(1));

    @Override
    public void onInitialize() {
        SpawnInit.init();

        // Entities
        FabricDefaultAttributeRegistry.register(SNAIL, SnailEntity.createMobAttributes());
        // Spawn Eggs
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "snail_spawn_egg"),
                new SpawnEggItem(SNAIL, 0x907c71, 0xedeacb, new Item.Settings().group(ItemGroup.MISC)));

        // Blocks
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cracked_stone_brick_stairs"), CRACKED_STONE_BRICK_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cracked_stone_brick_slab"), CRACKED_STONE_BRICK_SLAB);
        // BlockItems
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_stone_brick_stairs"),
                new BlockItem(CRACKED_STONE_BRICK_STAIRS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_stone_brick_slab"),
                new BlockItem(CRACKED_STONE_BRICK_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        // Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "snail_jar"), SNAIL_JAR);
    }
}
