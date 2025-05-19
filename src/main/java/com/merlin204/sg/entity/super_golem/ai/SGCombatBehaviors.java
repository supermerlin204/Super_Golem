package com.merlin204.sg.entity.super_golem.ai;



import com.merlin204.avalon.entity.condition.TargetInGirdCondition;
import com.merlin204.sg.entity.super_golem.SGPatch;
import com.merlin204.sg.epicfight.gameassets.animations.SuperGolemAnimation;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors.Behavior;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors.BehaviorSeries;
import yesman.epicfight.world.entity.ai.goal.CombatBehaviors.Builder;


public class SGCombatBehaviors {


    public static final Builder<SGPatch> TYPE1 = CombatBehaviors.<SGPatch>builder()


            .newBehaviorSeries(
                    BehaviorSeries.<SGPatch>builder().weight(10).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_1_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(0, 1, 0, 2)))
                            ).nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_1_2).withinDistance(0.0F,10F))
            )

            .newBehaviorSeries(
                    BehaviorSeries.<SGPatch>builder().weight(20).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_2_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(-1, 1, 1, 2)))
                            ).nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_2_2).withinDistance(0.0F,10F))
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_2_3).withinDistance(0.0F,10F))
            )

            .newBehaviorSeries(
                    BehaviorSeries.<SGPatch>builder().weight(20).cooldown(10).canBeInterrupted(false).looping(false)
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_3_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(1, 1, -1, 2)))
                            ).nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_3_2).withinDistance(0.0F,10F))
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_ATK_3_3).withinDistance(0.0F,10F))
            )

            .newBehaviorSeries(
                    BehaviorSeries.<SGPatch>builder().weight(50).cooldown(250).canBeInterrupted(false).looping(false)
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_SKILL_1).predicate(new TargetInGirdCondition(
                                    new TargetInGirdCondition.Rectangle(-2, 2, -2, -2)))
                            )
            )

            .newBehaviorSeries(
                    BehaviorSeries.<SGPatch>builder().weight(1).cooldown(200).canBeInterrupted(false).looping(false)
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_SKILL_2).predicate(new TargetInGirdCondition(true,
                                    new TargetInGirdCondition.Rectangle(-1, 2, 1, 13)))
                            )
            )

            .newBehaviorSeries(
                    BehaviorSeries.<SGPatch>builder().weight(100).cooldown(250).canBeInterrupted(false).looping(false)
                            .nextBehavior(Behavior.<SGPatch>builder().animationBehavior(SuperGolemAnimation.SG_SKILL_3).predicate(new TargetInGirdCondition(true,
                                    new TargetInGirdCondition.Rectangle(-1, 4, 1, 7)))
                            )
            )



            ;










}
