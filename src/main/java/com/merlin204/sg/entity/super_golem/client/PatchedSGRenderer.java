package com.merlin204.sg.entity.super_golem.client;


import com.merlin204.avalon.entity.client.model.EmptyEntityModel;
import com.merlin204.sg.entity.super_golem.SGPatch;
import com.merlin204.sg.epicfight.gameassets.mesh.SGMeshes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.IronGolemCrackinessLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.client.model.Meshes;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.client.mesh.IronGolemMesh;
import yesman.epicfight.client.renderer.patched.entity.PatchedLivingEntityRenderer;
import yesman.epicfight.client.renderer.patched.layer.PatchedGolemCrackLayer;
import yesman.epicfight.mixin.client.MixinEntityRenderer;
import yesman.epicfight.mixin.client.MixinLivingEntityRenderer;

@OnlyIn(Dist.CLIENT)

public class PatchedSGRenderer extends PatchedLivingEntityRenderer<PathfinderMob, SGPatch, EmptyEntityModel<PathfinderMob>, SGRenderer, SGMesh> {
    public PatchedSGRenderer(EntityRendererProvider.Context context, EntityType<?> entityType) {
        super(context, entityType);
    }


    @Override
    public void render(PathfinderMob entity, SGPatch entitypatch, SGRenderer renderer, MultiBufferSource buffer, PoseStack poseStack, int packedLight, float partialTicks) {
        RenderNameTagEvent renderNameplateEvent = new RenderNameTagEvent(entity, entity.getDisplayName(), renderer, poseStack, buffer, packedLight, partialTicks);
        MinecraftForge.EVENT_BUS.post(renderNameplateEvent);
        MixinEntityRenderer entityRendererAccessor = (MixinEntityRenderer)renderer;
        if ((entityRendererAccessor.invokeShouldShowName(entity) || renderNameplateEvent.getResult() == Event.Result.ALLOW) && renderNameplateEvent.getResult() != Event.Result.DENY) {
            entityRendererAccessor.invokeRenderNameTag(entity, renderNameplateEvent.getContent(), poseStack, buffer, packedLight);
        }
        Minecraft mc = Minecraft.getInstance();
        MixinLivingEntityRenderer livingEntityRendererAccessor = (MixinLivingEntityRenderer)renderer;
        boolean isVisible = true;
        boolean isVisibleToPlayer = !isVisible && !entity.isInvisibleTo(mc.player);
        boolean isGlowing = mc.shouldEntityAppearGlowing(entity);
        RenderType renderType = livingEntityRendererAccessor.invokeGetRenderType(entity, isVisible, isVisibleToPlayer, isGlowing);
        SGMesh mesh = this.getMeshProvider(entitypatch).get();
        Armature armature = entitypatch.getArmature();

        poseStack.pushPose();
        this.mulPoseStack(poseStack, armature, entity, entitypatch, partialTicks);
        this.setArmaturePose(entitypatch, armature, partialTicks);

        if (renderType != null) {

            mesh.draw(poseStack, buffer, renderType, packedLight, 1.0F, 1.0F, 1.0F, isVisibleToPlayer ? 0.15F : 1.0F, this.getOverlayCoord(entity, entitypatch, partialTicks), armature, armature.getPoseMatrices());


                if (entity.getHealth() <= entity.getMaxHealth() * 0.25F){
                    mesh.draw(poseStack, buffer, RenderType.entityCutoutNoCull(ResourceLocation.withDefaultNamespace("textures/entity/iron_golem/iron_golem_crackiness_high.png")), packedLight, 1.0F, 1.0F, 1.0F, 0.8F, OverlayTexture.NO_OVERLAY, entitypatch.getArmature(), armature.getPoseMatrices());
                }else if (entity.getHealth() <= entity.getMaxHealth() * 0.5F){
                    mesh.draw(poseStack, buffer, RenderType.entityCutoutNoCull(ResourceLocation.withDefaultNamespace("textures/entity/iron_golem/iron_golem_crackiness_medium.png")), packedLight, 1.0F, 1.0F, 1.0F, 0.8F, OverlayTexture.NO_OVERLAY, entitypatch.getArmature(), armature.getPoseMatrices());
                }else if (entity.getHealth() <= entity.getMaxHealth() * 0.75F){
                    mesh.draw(poseStack, buffer, RenderType.entityCutoutNoCull(ResourceLocation.withDefaultNamespace("textures/entity/iron_golem/iron_golem_crackiness_low.png")), packedLight, 1.0F, 1.0F, 1.0F, 0.8F, OverlayTexture.NO_OVERLAY, entitypatch.getArmature(), armature.getPoseMatrices());
                }

            this.renderLayer(renderer, entitypatch, entity, armature.getPoseMatrices(), buffer, poseStack, packedLight, partialTicks);

            if (Minecraft.getInstance().getEntityRenderDispatcher().shouldRenderHitBoxes()) {
                entitypatch.getClientAnimator().renderDebuggingInfoForAllLayers(poseStack, buffer, partialTicks);
            }
        }

        poseStack.popPose();
    }




    public AssetAccessor<SGMesh> getDefaultMesh() {
        return SGMeshes.SUPER_GOLEM_MESH;
    }
}