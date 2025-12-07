package com.merlin204.sg.entity.super_golem.client;

import com.merlin204.avalon.entity.client.model.EmptyEntityModel;
import com.merlin204.sg.main.SGMOD;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SGRenderer extends MobRenderer<PathfinderMob, EmptyEntityModel<PathfinderMob>> {

    private final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("minecraft","textures/entity/iron_golem/iron_golem.png");

    public SGRenderer(EntityRendererProvider.Context context) {
        super(context, new EmptyEntityModel<>(), 0);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PathfinderMob Entity) {
        return TEXTURE;
    }

}