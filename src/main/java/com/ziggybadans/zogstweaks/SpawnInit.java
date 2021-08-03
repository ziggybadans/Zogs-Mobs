package com.ziggybadans.zogstweaks;

import com.google.common.base.Preconditions;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

import java.util.function.Predicate;

@SuppressWarnings("deprecation")
public class SpawnInit {

    public static void addSpawn(Predicate<BiomeSelectionContext> BiomeSelector, SpawnGroup spawnGroup, SpawnSettings.SpawnEntry spawnEntry) {
        Preconditions.checkArgument(spawnEntry.type.getSpawnGroup() != spawnGroup.MISC,
                "MISC spawns pigs");

        Identifier id = Registry.ENTITY_TYPE.getId(spawnEntry.type);
        Preconditions.checkState(id != Registry.ENTITY_TYPE.getDefaultId(), "Unregistered entity type: %s", spawnEntry.type);

        BiomeModifications.create(id).add(ModificationPhase.ADDITIONS, BiomeSelector, context -> context.getSpawnSettings().addSpawn(spawnGroup, spawnEntry));
    }

    public static void normalSpawn() {
        Predicate<BiomeSelectionContext> biomeSelector = (context) -> {
            Biome.Category category = context.getBiome().getCategory();
            return category == Biome.Category.PLAINS;
        };

        addSpawn(biomeSelector, ZogsTweaks.SNAIL.getSpawnGroup(),
                new SpawnSettings.SpawnEntry(ZogsTweaks.SNAIL, 100, 1, 5));
    }

    public static void init() {
        normalSpawn();
    }
}
