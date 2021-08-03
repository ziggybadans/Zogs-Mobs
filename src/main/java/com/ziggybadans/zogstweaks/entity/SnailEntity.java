package com.ziggybadans.zogstweaks.entity;

import com.ziggybadans.zogstweaks.ZogsTweaks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"EntityConstructor", "deprecation"})
public class SnailEntity extends AnimalEntity {

    public SnailEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new WanderAroundGoal(this, 0.1D));
    }

    public static DefaultAttributeContainer.Builder createSnailAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == ZogsTweaks.SNAIL_JAR && this.isAlive()) {
            this.playSound(SoundEvents.BLOCK_ANVIL_DESTROY, 1.0F, 1.0F);
            itemStack.decrement(1);
            this.remove(RemovalReason.DISCARDED);
            return ActionResult.success(this.world.isClient);
        }
        else { return super.interactMob(player, hand); }
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(Blocks.COBBLESTONE) ? 10.0F : world.getBrightness(pos) - 0.5F;
    }


    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return this.world.getBlockState(blockunderentity).isOf(Blocks.COBBLESTONE) && !world.containsFluid(this.getBoundingBox())
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside() && view.intersectsEntities(this);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
