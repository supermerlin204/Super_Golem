package com.merlin204.sg.epicfight.gameassets.armature;

import com.merlin204.sg.entity.super_golem.SGArmature;
import com.merlin204.sg.main.SGMOD;
import net.minecraft.world.entity.EntityType;
import yesman.epicfight.gameasset.Armatures;

public class SGArmatures {
    public static Armatures.ArmatureAccessor<SGArmature> SUPER_GOLEM_ARMATURE = Armatures.ArmatureAccessor.create(SGMOD.MOD_ID, "entity/super_golem", SGArmature::new);


    public static void registerArmatures(){

        Armatures.registerEntityTypeArmature(EntityType.IRON_GOLEM, SUPER_GOLEM_ARMATURE);


    }

}