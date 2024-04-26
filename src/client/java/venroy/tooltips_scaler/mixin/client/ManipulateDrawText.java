//package venroy.tooltips_scaler.mixin.client;
//
//import net.minecraft.client.font.TextRenderer;
//import net.minecraft.client.gui.tooltip.TooltipComponent;
//import net.minecraft.client.render.VertexConsumerProvider;
//import org.joml.Matrix4f;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(TooltipComponent.class)
//public class ManipulateDrawText {
//    @Inject(method = "drawText", at = @At(value = "HEAD"))
//    private void alter(TextRenderer textRenderer, int x, int y, Matrix4f matrix, VertexConsumerProvider.Immediate vertexConsumers, CallbackInfo ci){
//        matrix.scale(2,2,1);
//    }
//}
