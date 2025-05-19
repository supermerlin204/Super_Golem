package com.merlin204.sg.entity.super_golem;

import com.merlin204.sg.entity.super_golem.ai.SGCombatBehaviors;
import com.merlin204.sg.epicfight.gameassets.animations.SuperGolemAnimation;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import yesman.epicfight.api.animation.*;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.utils.math.MathUtils;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.entitypatch.Factions;
import yesman.epicfight.world.capabilities.entitypatch.MobPatch;
import yesman.epicfight.world.damagesource.StunType;
import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
import yesman.epicfight.world.entity.ai.goal.AnimatedAttackGoal;
import yesman.epicfight.world.entity.ai.goal.TargetChasingGoal;

import java.util.Iterator;
import java.util.Set;

public class SGPatch extends MobPatch<PathfinderMob> {
    public SGPatch() {
        super(Factions.VILLAGER);
    }

    protected void initAI() {
        super.initAI();
        this.original.goalSelector.addGoal(0, new AnimatedAttackGoal<>(this, SGCombatBehaviors.TYPE1.build(this)));

        (this.original).goalSelector.addGoal(1, new TargetChasingGoal(this, this.original, 1.0, false));
    }

    protected void selectGoalToRemove(Set<Goal> toRemove) {
        super.selectGoalToRemove(toRemove);
        Iterator var2 = (this.original).goalSelector.getAvailableGoals().iterator();

        while(var2.hasNext()) {
            WrappedGoal wrappedGoal = (WrappedGoal)var2.next();
            Goal goal = wrappedGoal.getGoal();
            if (goal instanceof MoveTowardsTargetGoal) {
                toRemove.add(goal);
            }
        }

    }


    @Override
    public void poseTick(DynamicAnimation animation, Pose pose, float elapsedTime, float partialTicks) {
    }

    public static void initAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.IRON_GOLEM,  EpicFightAttributes.MAX_STRIKES.get(), 10);
        event.add(EntityType.IRON_GOLEM, EpicFightAttributes.IMPACT.get(), 30);
        event.add(EntityType.IRON_GOLEM, EpicFightAttributes.WEIGHT.get(), 200);
    }

    public void initAnimator(Animator animator) {
        super.initAnimator(animator);
        animator.addLivingAnimation(LivingMotions.IDLE, SuperGolemAnimation.SG_IDLE);
        animator.addLivingAnimation(LivingMotions.WALK, SuperGolemAnimation.SG_WALK);
        animator.addLivingAnimation(LivingMotions.CHASE, SuperGolemAnimation.SG_RUN);
        animator.addLivingAnimation(LivingMotions.DEATH, SuperGolemAnimation.SG_DEATH);
        animator.addLivingAnimation(LivingMotions.FALL, SuperGolemAnimation.SG_DEATH);
    }

    public void updateMotion(boolean considerInaction) {
        super.commonMobUpdateMotion(considerInaction);
    }

    public SoundEvent getWeaponHitSound(InteractionHand hand) {
        return  EpicFightSounds.BLUNT_HIT_HARD.get();
    }

    public SoundEvent getSwingSound(InteractionHand hand) {
        return EpicFightSounds.WHOOSH_BIG.get();
    }

    public AnimationManager.AnimationAccessor<? extends StaticAnimation> getHitAnimation(StunType stunType) {
        return null;
    }
}
