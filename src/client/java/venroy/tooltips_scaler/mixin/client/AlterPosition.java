package venroy.tooltips_scaler.mixin.client;

import venroy.tooltips_scaler.Tooltips_scaler;
import venroy.tooltips_scaler.cloth.cloth_config;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.client.gui.tooltip.TooltipPositioner;
import java.util.List;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DrawContext.class)
public abstract class AlterPosition {



    // Using an invoke inject here because the tooltip coordinates get checked for out of bounds positions. I want the scroll offset to only apply after the bound check.
    // Targeting a method invoke because it was just conveniently placed after the bound check.

    // l is the variable that determines y-axis position of a tooltip.
    @ModifyVariable (method = "drawTooltip(Lnet/minecraft/client/font/TextRenderer;Ljava/util/List;IILnet/minecraft/client/gui/tooltip/TooltipPositioner;)V", ordinal = 7, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;push()V", shift = At.Shift.BEFORE))
    private int modifyYAxisf (int y) {
        return y + Tooltips_scaler.config.modifyYAxisValue;
    }

    // k is the variable that determines x-axis position of a tooltip.
    @ModifyVariable (method = "drawTooltip(Lnet/minecraft/client/font/TextRenderer;Ljava/util/List;IILnet/minecraft/client/gui/tooltip/TooltipPositioner;)V", ordinal = 6, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;push()V", shift = At.Shift.BEFORE))
    private int modifyXAxis (int x) {
        return x + Tooltips_scaler.config.modifyXAxisValue;
    }
}