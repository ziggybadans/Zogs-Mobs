package com.ziggybadans.zogstweaks.client.renderer;

import com.ziggybadans.zogstweaks.ZogsTweaks;
import com.ziggybadans.zogstweaks.ZogsTweaksClient;
import com.ziggybadans.zogstweaks.client.model.SnailEntityModel;
import com.ziggybadans.zogstweaks.entity.SnailEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SnailEntityRenderer extends MobEntityRenderer<SnailEntity, SnailEntityModel> {

    public SnailEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SnailEntityModel(context.getPart(ZogsTweaksClient.MODEL_SNAIL_LAYER)),0.25f);
    }

    @Override
    public Identifier getTexture(SnailEntity entity) {
        return new Identifier(ZogsTweaks.MOD_ID, "textures/entity/snail/snail.png");
    }
}
