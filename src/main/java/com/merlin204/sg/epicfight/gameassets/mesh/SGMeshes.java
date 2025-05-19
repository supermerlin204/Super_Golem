package com.merlin204.sg.epicfight.gameassets.mesh;

import com.merlin204.sg.entity.super_golem.client.SGMesh;
import com.merlin204.sg.main.SGMOD;
import yesman.epicfight.api.client.model.Meshes;

public class SGMeshes {

    public static final Meshes.MeshAccessor<SGMesh> SUPER_GOLEM_MESH = Meshes.MeshAccessor.create(SGMOD.MOD_ID, "entity/super_golem", (jsonModelLoader) -> jsonModelLoader.loadSkinnedMesh(SGMesh::new));

}
