package com.ziggybadans.zogstweaks;

import com.ziggybadans.zogstweaks.blocks.RockPileBlock;
import com.ziggybadans.zogstweaks.entity.SnailEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.*;
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
    public static final StairsBlock CRACKED_STONE_BRICK_STAIRS = new ModStairsBlock(Blocks.STONE_BRICKS.getDefaultState(),
            FabricBlockSettings.of(Material.STONE).strength(0.25F, 6F));
    public static final SlabBlock CRACKED_STONE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(0.25F, 6F));
    public static final WallBlock POLISHED_GRANITE_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.POLISHED_GRANITE));
    public static final WallBlock POLISHED_ANDESITE_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.POLISHED_ANDESITE));
    public static final WallBlock POLISHED_DIORITE_WALL = new WallBlock(FabricBlockSettings.copy(Blocks.POLISHED_DIORITE));
    public static final RockPileBlock ROCK_PILE = new RockPileBlock(FabricBlockSettings.copy(Blocks.STONE_BUTTON));

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
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_granite_wall"), POLISHED_GRANITE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_andesite_wall"), POLISHED_ANDESITE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "polished_diorite_wall"), POLISHED_DIORITE_WALL);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "rock_pile"), ROCK_PILE);
        // BlockItems
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_stone_brick_stairs"),
                new BlockItem(CRACKED_STONE_BRICK_STAIRS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cracked_stone_brick_slab"),
                new BlockItem(CRACKED_STONE_BRICK_SLAB, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_granite_wall"),
                new BlockItem(POLISHED_GRANITE_WALL, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_andesite_wall"),
                new BlockItem(POLISHED_ANDESITE_WALL, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polished_diorite_wall"),
                new BlockItem(POLISHED_DIORITE_WALL, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "rock_pile"),
                new BlockItem(ROCK_PILE, new FabricItemSettings().group(ZogsTweaks.MAIN)));

        // Items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "snail_jar"), SNAIL_JAR);
    }
}
