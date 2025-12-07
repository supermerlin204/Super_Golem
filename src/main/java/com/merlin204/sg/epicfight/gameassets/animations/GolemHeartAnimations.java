package com.merlin204.sg.epicfight.gameassets.animations;

import com.merlin204.avalon.epicfight.animations.AvalonAttackAnimation;
import com.merlin204.avalon.epicfight.animations.AvalonMovementAnimation;
import com.merlin204.avalon.util.AvalonAnimationUtils;
import com.merlin204.avalon.util.AvalonEventUtils;
import com.merlin204.sg.entity.super_golem.SGArmature;
import com.merlin204.sg.epicfight.gameassets.armature.SGArmatures;
import com.merlin204.sg.main.SGMOD;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;

import java.util.List;
import java.util.function.Supplier;

public class GolemHeartAnimations {
    public static final Collider GOLEM_HAND= new MultiOBBCollider(8, 0.5, 0.5, 0.5, 0.0, 0, 0);

    public static final Armatures.ArmatureAccessor<? extends Armature> ARMATURE= Armatures.ArmatureAccessor.create(SGMOD.MOD_ID, "golem_heart", Armature::new);


    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> KNEEL;
    public static AnimationManager.AnimationAccessor<AvalonMovementAnimation> SNEAK;
    public static AnimationManager.AnimationAccessor<AvalonMovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<AvalonMovementAnimation> RUN;

    public static AnimationManager.AnimationAccessor<AvalonAttackAnimation> ATK_1;
    public static AnimationManager.AnimationAccessor<AvalonAttackAnimation> ATK_2;
    public static AnimationManager.AnimationAccessor<AvalonAttackAnimation> ATK_3;
    public static AnimationManager.AnimationAccessor<AvalonAttackAnimation> RUN_ATK;
    public static AnimationManager.AnimationAccessor<AvalonAttackAnimation> AIR_ATK;




    public static void buildVFXAnimations(AnimationManager.AnimationBuilder builder) {
        Armatures.ArmatureAccessor<Armature> armature = Armatures.ArmatureAccessor.create(SGMOD.MOD_ID, "golem_heart", Armature::new);

        IDLE = builder.nextAccessor("golem_heart/golem_heart_idle", accessor -> new StaticAnimation(0.15F,true, accessor, armature));

        KNEEL = builder.nextAccessor("golem_heart/golem_heart_kneel", accessor -> new StaticAnimation(0.15F,true, accessor, armature));

        SNEAK = builder.nextAccessor("golem_heart/golem_heart_sneak", accessor -> new AvalonMovementAnimation(0.15F,true, accessor, armature,1.5F));

        WALK = builder.nextAccessor("golem_heart/golem_heart_walk", accessor -> new AvalonMovementAnimation(0.15F,true, accessor, armature,1.5F));

        RUN = builder.nextAccessor("golem_heart/golem_heart_run", accessor -> new AvalonMovementAnimation(0.15F,true, accessor, armature,1.5F));

        ATK_1 = builder.nextAccessor("golem_heart/golem_heart_atk_1", accessor -> new AvalonAttackAnimation(0.1F, accessor, armature,
                createSimplePhaseDownR(30,40,50),createSimplePhaseUpL(55,65,60))
                .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.COMBO_ATTACK_DIRECTION_MODIFIER));

        ATK_2 = builder.nextAccessor("golem_heart/golem_heart_atk_2", accessor -> new AvalonAttackAnimation(0.1F, accessor, armature,
                createSimplePhaseUpR(30,40,50),createSimplePhaseDownL(45,55,70))
                .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.COMBO_ATTACK_DIRECTION_MODIFIER));

        ATK_3 = builder.nextAccessor("golem_heart/golem_heart_atk_3", accessor -> new AvalonAttackAnimation(0.1F, accessor, armature,
                createSimplePhaseDownR(30,40,50),createSimplePhaseUpL(30,40,50),
                createSimplePhaseDownL(30,40,50),createSimplePhaseUpR(30,40,50))
                .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.COMBO_ATTACK_DIRECTION_MODIFIER));

        RUN_ATK = builder.nextAccessor("golem_heart/golem_heart_run_atk", accessor -> new AvalonAttackAnimation(0.1F, accessor, armature,
                createSimplePhaseDownR(25,35,45),createSimplePhaseDownL(25,35,45))
                .addProperty(AnimationProperty.StaticAnimationProperty.POSE_MODIFIER, Animations.ReusableSources.COMBO_ATTACK_DIRECTION_MODIFIER));

        AIR_ATK = builder.nextAccessor("golem_heart/golem_heart_air_atk", accessor -> new AvalonAttackAnimation(0.1F, accessor, armature,
                createSimplePhaseDownR(20,30,50),
                createSimplePhaseUpL(20,30,50),
                createSimplePhaseDownL(20,30,50),
                createSimplePhaseUpR(20,30,50)));


























    }

    private static AnimationEvent.InPeriodEvent groundSplitAtkUpL(int startFrame, int endFrame){
        return AvalonEventUtils.groundSplitAtk(startFrame,endFrame,ARMATURE.get().searchJointByName("garm_up_4_L"),Vec3.ZERO,new Vec3(0,0.5,0),5,2);
    }

    private static AnimationEvent.InPeriodEvent groundSplitAtkUpR(int startFrame, int endFrame){
        return AvalonEventUtils.groundSplitAtk(startFrame,endFrame,ARMATURE.get().searchJointByName("garm_up_4_R"),Vec3.ZERO,new Vec3(0,0.5,0),5,2);
    }

    private static AnimationEvent.InPeriodEvent groundSplitAtkDownL(int startFrame, int endFrame){
        return AvalonEventUtils.groundSplitAtk(startFrame,endFrame,ARMATURE.get().searchJointByName("garm_down_4_L"),Vec3.ZERO,new Vec3(0,0.5,0),5,2);
    }

    private static AnimationEvent.InPeriodEvent groundSplitAtkDownR(int startFrame, int endFrame){
        return AvalonEventUtils.groundSplitAtk(startFrame,endFrame,ARMATURE.get().searchJointByName("garm_down_4_R"),Vec3.ZERO,new Vec3(0,0.5,0),5,2);
    }


    private static AvalonAttackAnimation.AvalonPhase  createSimplePhaseUpL(int startFrame, int endFrame,int waitFrame) {
        Supplier<AttackAnimation.JointColliderPair[]> supplierL = () -> {
            List<AttackAnimation.JointColliderPair> atkJoints =
                    List.of(AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_1_L"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_2_L"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_3_L"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_4_L"),GOLEM_HAND));
            return atkJoints.toArray(new AttackAnimation.JointColliderPair[0]);
        };
        return AvalonAnimationUtils.createSimplePhase(startFrame,endFrame,waitFrame, InteractionHand.MAIN_HAND,supplierL.get());
    }
    private static AvalonAttackAnimation.AvalonPhase createSimplePhaseUpR(int startFrame, int endFrame,int waitFrame) {

        Supplier<AttackAnimation.JointColliderPair[]> supplierR = () -> {
            List<AttackAnimation.JointColliderPair> atkJoints =
                    List.of(AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_1_R"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_2_R"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_3_R"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_up_4_R"),GOLEM_HAND));
            return atkJoints.toArray(new AttackAnimation.JointColliderPair[0]);
        };
        return AvalonAnimationUtils.createSimplePhase(startFrame,endFrame,waitFrame,InteractionHand.MAIN_HAND,supplierR.get());
    }

    private static AvalonAttackAnimation.AvalonPhase  createSimplePhaseDownL(int startFrame, int endFrame,int waitFrame) {
        Supplier<AttackAnimation.JointColliderPair[]> supplierL = () -> {
            List<AttackAnimation.JointColliderPair> atkJoints =
                    List.of(AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_1_L"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_2_L"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_3_L"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_4_L"),GOLEM_HAND));
            return atkJoints.toArray(new AttackAnimation.JointColliderPair[0]);
        };
        return AvalonAnimationUtils.createSimplePhase(startFrame,endFrame,waitFrame, InteractionHand.MAIN_HAND,supplierL.get());
    }

    private static AvalonAttackAnimation.AvalonPhase  createSimplePhaseDownR(int startFrame, int endFrame,int waitFrame) {
        Supplier<AttackAnimation.JointColliderPair[]> supplierL = () -> {
            List<AttackAnimation.JointColliderPair> atkJoints =
                    List.of(AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_1_R"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_2_R"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_3_R"),GOLEM_HAND),
                            AttackAnimation.JointColliderPair.of(ARMATURE.get().searchJointByName("garm_down_4_R"),GOLEM_HAND));
            return atkJoints.toArray(new AttackAnimation.JointColliderPair[0]);
        };
        return AvalonAnimationUtils.createSimplePhase(startFrame,endFrame,waitFrame, InteractionHand.MAIN_HAND,supplierL.get());
    }




}
