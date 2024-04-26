package venroy.tooltips_scaler.mixin.client;


import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.tooltip.HoveredTooltipPositioner;
import net.minecraft.client.gui.tooltip.TooltipPositioner;
import org.apache.logging.log4j.core.pattern.TextRenderer;
import org.joml.Vector2ic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(HandledScreen.class)
public class tooltips_Inventory {





    @Inject(method = "drawMouseoverTooltip", at = @At(value = "HEAD"))
    private void injectHead(DrawContext context, int x, int y, CallbackInfo ci) {
        context.getMatrices().push();
        context.getMatrices().scale(2,2 ,1);//fuck around and add slider

    }
//    @Redirect(method = "renderWithTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/screen/Screen;textRenderer:Lnet/minecraft/client/font/TextRenderer;"))
//    private TextRenderer redirectTextRenderer(Screen instance) {
//        return instance.textRenderer;
//    }

    @Inject(method = "drawMouseoverTooltip", at = @At("TAIL"))
    private void injectTail(DrawContext context, int x, int y, CallbackInfo ci) {
        context.getMatrices().pop();
    }
}
