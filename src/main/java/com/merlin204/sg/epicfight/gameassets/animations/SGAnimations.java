package com.merlin204.sg.epicfight.gameassets.animations;


import com.merlin204.sg.main.SGMOD;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.AnimationManager;


@Mod.EventBusSubscriber(modid = SGMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SGAnimations {

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(SGMOD.MOD_ID, (builder)->{
            SuperGolemAnimation.buildVFXAnimations(builder);
            GolemHeartAnimations.buildVFXAnimations(builder);



        });
    }


}