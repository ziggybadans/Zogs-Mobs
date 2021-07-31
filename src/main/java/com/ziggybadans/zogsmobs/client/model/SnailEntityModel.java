package com.ziggybadans.zogsmobs.client.model;

import com.google.common.collect.ImmutableList;
import com.ziggybadans.zogsmobs.entity.SnailEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;

public class SnailEntityModel extends EntityModel<SnailEntity> {

    private final ModelPart body;
    private final ModelPart shell;
    private final ModelPart left_ear;
    private final ModelPart right_ear;

    public SnailEntityModel(ModelPart root) {
        this.body = root.getChild(EntityModelPartNames.BODY);
        this.shell = root.getChild(EntityModelPartNames.CUBE);
        this.left_ear = root.getChild(EntityModelPartNames.LEFT_EAR);
        this.right_ear = root.getChild(EntityModelPartNames.RIGHT_EAR);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0,0)
                        .cuboid(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 6.0F, false)
                , ModelTransform.pivot(0.0F, 24.0F, 4.0F));

        modelPartData.addChild(EntityModelPartNames.CUBE, ModelPartBuilder.create().uv(0,8)
                        .cuboid(-2F,-5F,0F,4F,4F,4F,false)
                , ModelTransform.of(0.0F, 24.0F, 4.0F, 1.1781F, 0.0F, 0.0F));

        modelPartData.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(0,2)
                        .cuboid(-0.7F, -2.0F, 0.25F, 0.0F, 2.0F, 1.0F, false)
                , ModelTransform.of(0.0F, 23.0F, -2.5F, 0.3927F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(0,0)
                        .cuboid(0.7F, -2.0F, 0.25F, 0.0F, 2.0F, 1.0F, false)
                , ModelTransform.of(0.0F, 23.0F, -2.5F, 0.3927F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(SnailEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.body).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
        ImmutableList.of(this.shell).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
        ImmutableList.of(this.left_ear).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
        ImmutableList.of(this.right_ear).forEach((modelRenderer) -> {
            modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        });
    }
}
