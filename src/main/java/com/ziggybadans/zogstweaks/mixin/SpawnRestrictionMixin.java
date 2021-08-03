package com.ziggybadans.zogstweaks.mixin;

import com.ziggybadans.zogstweaks.ZogsTweaks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SpawnRestriction.class)
public class SpawnRestrictionMixin {

    @Shadow
    private static <T extends MobEntity> void register(EntityType<T> type, SpawnRestriction.Location location,
                                                       Heightmap.Type heightmapType, SpawnRestriction.SpawnPredicate<T> predicate) {

    }

    static {
        register(ZogsTweaks.SNAIL, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canMobSpawn);
    }
}
