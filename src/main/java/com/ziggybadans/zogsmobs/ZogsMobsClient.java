package com.ziggybadans.zogsmobs;

import com.ziggybadans.zogsmobs.client.model.SnailEntityModel;
import com.ziggybadans.zogsmobs.client.renderer.SnailEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ZogsMobsClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_SNAIL_LAYER = new EntityModelLayer(new Identifier("zogsmobs", "snail"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ZogsMobs.SNAIL, SnailEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SNAIL_LAYER, SnailEntityModel::getTexturedModelData);
    }
}
