package com.merlin204.sg.events;



import com.merlin204.sg.entity.super_golem.SGPatch;
import com.merlin204.sg.epicfight.gameassets.armature.SGArmatures;
import com.merlin204.sg.main.SGMOD;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import yesman.epicfight.api.forgeevent.EntityPatchRegistryEvent;

@Mod.EventBusSubscriber(modid = SGMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {


    @SubscribeEvent
    public static void setPatch(EntityPatchRegistryEvent event) {

        event.getTypeEntry().put(EntityType.IRON_GOLEM,(entity -> SGPatch::new));


    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(SGArmatures::registerArmatures);
        event.enqueueWork(SGArmatures::registerArmatures);


    }






}