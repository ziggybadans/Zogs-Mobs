package com.ziggybadans.zogstweaks;

import com.ziggybadans.zogstweaks.client.model.SnailEntityModel;
import com.ziggybadans.zogstweaks.client.renderer.SnailEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ZogsTweaksClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_SNAIL_LAYER = new EntityModelLayer(new Identifier(ZogsTweaks.MOD_ID, "snail"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ZogsTweaks.SNAIL, SnailEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SNAIL_LAYER, SnailEntityModel::getTexturedModelData);
    }
}
