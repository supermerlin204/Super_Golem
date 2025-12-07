package com.merlin204.sg.events;



import com.merlin204.sg.entity.super_golem.client.PatchedSGRenderer;
import com.merlin204.sg.entity.super_golem.client.SGRenderer;
import com.merlin204.sg.main.SGMOD;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import yesman.epicfight.api.client.forgeevent.PatchedRenderersEvent;

import static com.mojang.text2speech.Narrator.LOGGER;

@Mod.EventBusSubscriber(modid = SGMOD.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityType.IRON_GOLEM, SGRenderer::new);



    }

    @SubscribeEvent
    public static void onPatchedRenderer(PatchedRenderersEvent.Add event){
//        event.addPatchedEntityRenderer(SGEntities.BLADEWAVE.get(), entityType -> new PatchedBladeWaveRenderer(event.getContext(), entityType).initLayerLast(event.getContext(), entityType));
        event.addPatchedEntityRenderer(EntityType.IRON_GOLEM,entityType -> new PatchedSGRenderer(event.getContext(),entityType).initLayerLast(event.getContext(),entityType));
    }







}