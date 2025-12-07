package com.merlin204.sg.entity.super_golem.ai;



import com.merlin204.avalon.entity.ai.AvalonCombatBehaviors;
import com.merlin204.avalon.entity.condition.TargetInGirdCondition;
import com.merlin204.sg.entity.super_golem.SGPatch;
import com.merlin204.sg.epicfight.gameassets.animations.SuperGolemAnimation;



public class SGCombatBehaviors {


    public static final AvalonCombatBehaviors.Builder<SGPatch> TYPE1 = AvalonCombatBehaviors.<SGPatch>builder()


            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<SGPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_1_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(0, 1, 0, 2)))
                            ).nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_1_2).withinDistance(0.0F,10F))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<SGPatch>builder().weight(20).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_2_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(-1, 1, 1, 2)))
                            ).nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_2_2).withinDistance(0.0F,10F))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_2_3).withinDistance(0.0F,10F))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<SGPatch>builder().weight(20).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_3_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(1, 1, -1, 2)))
                            ).nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_3_2).withinDistance(0.0F,10F))
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_3_3).withinDistance(0.0F,10F))
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<SGPatch>builder().weight(50).cooldown(250).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_SKILL_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(-2, 2, -2, -2)))
                            )
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<SGPatch>builder().weight(1).cooldown(200).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_SKILL_2).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(-1, 2, 1, 13)))
                            )
            )

            .newBehaviorSeries(
                    AvalonCombatBehaviors.BehaviorSeries.<SGPatch>builder().weight(100).cooldown(250).canBeInterrupted(false).looping(false)
                            .nextBehavior(AvalonCombatBehaviors.Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_SKILL_3).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(-1, 4, 1, 7)))
                            )
            )



            ;










}
