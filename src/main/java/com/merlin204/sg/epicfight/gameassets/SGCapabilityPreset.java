package com.merlin204.sg.epicfight.gameassets;

import com.merlin204.avalon.epicfight.gameassets.AvalonCategories;
import com.merlin204.sg.epicfight.gameassets.animations.GolemHeartAnimations;
import com.merlin204.sg.main.SGMOD;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = SGMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SGCapabilityPreset { public static final Function<Item, CapabilityItem.Builder> GOLEM_HEART = (item) ->
            (CapabilityItem.Builder) WeaponCapability.builder().category(AvalonCategories.ANIMATION_ITEM)
                    .styleProvider((livingEntityPatch) -> CapabilityItem.Styles.ONE_HAND)
                    .hitSound(EpicFightSounds.BLUNT_HIT_HARD.get())
                    .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                    .hitParticle(EpicFightParticles.HIT_BLUNT.get())
                    .collider(ColliderPreset.TOOLS)
                    .canBePlacedOffhand(false)
                    .newStyleCombo(CapabilityItem.Styles.ONE_HAND, GolemHeartAnimations.ATK_1,GolemHeartAnimations.ATK_2,GolemHeartAnimations.ATK_3,GolemHeartAnimations.RUN_ATK,GolemHeartAnimations.AIR_ATK)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.IDLE, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.WALK, GolemHeartAnimations.WALK)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.CHASE, GolemHeartAnimations.RUN)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.RUN, GolemHeartAnimations.RUN)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.JUMP, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.FALL, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.FLOAT, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.FLY, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.DEATH, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.SWIM, GolemHeartAnimations.IDLE)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.KNEEL, GolemHeartAnimations.KNEEL)
                    .livingMotionModifier(CapabilityItem.Styles.ONE_HAND, LivingMotions.SNEAK, GolemHeartAnimations.SNEAK);
    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(SGMOD.MOD_ID, "golem_heart"), GOLEM_HEART);
    }

}
