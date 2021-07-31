package com.ziggybadans.zogsmobs.client.renderer;

import com.ziggybadans.zogsmobs.ZogsMobsClient;
import com.ziggybadans.zogsmobs.client.model.SnailEntityModel;
import com.ziggybadans.zogsmobs.entity.SnailEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SnailEntityRenderer extends MobEntityRenderer<SnailEntity, SnailEntityModel> {

    public SnailEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SnailEntityModel(context.getPart(ZogsMobsClient.MODEL_SNAIL_LAYER)),0.25f);
    }

    @Override
    public Identifier getTexture(SnailEntity entity) {
        return new Identifier("zogsmobs", "textures/entity/snail/snail.png");
    }
}
