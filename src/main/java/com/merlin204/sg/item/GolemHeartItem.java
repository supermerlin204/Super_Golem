package com.merlin204.sg.item;


import com.merlin204.avalon.item.animationitem.IAvalonAnimationItem;
import com.merlin204.avalon.main.AvalonMOD;
import com.merlin204.sg.main.SGMOD;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.Vec2;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.item.WeaponItem;

public class GolemHeartItem extends WeaponItem implements IAvalonAnimationItem {

    public final Armatures.ArmatureAccessor<? extends Armature> ARMATUREACCESSOR = Armatures.ArmatureAccessor.create(SGMOD.MOD_ID, "golem_heart", Armature::new);

    public GolemHeartItem(Tier tier, int damageIn, float speedIn, Properties builder) {
        super(tier, damageIn, speedIn, builder);
    }


    @Override
    public Armatures.ArmatureAccessor<? extends Armature> getArmature() {
        return ARMATUREACCESSOR;
    }

    @Override
    public Vec2 getHitBox() {
        return new  Vec2(1,2.3F);
    }
}
