package venroy.tooltips_scaler.mixin.client;


import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import venroy.tooltips_scaler.Tooltips_scaler;

@Mixin(InGameHud.class)
public class Tooltips_scalerClient {
	@Shadow private int scaledWidth;
	@Shadow private int scaledHeight;
	@Shadow private int heldItemTooltipFade;

	@Inject(method = "renderHeldItemTooltip", at = @At("HEAD"))
	private void injectHead(DrawContext context, CallbackInfo ci) {
		context.getMatrices().push();
		context.getMatrices().scale(Tooltips_scaler.config.cloth_size, Tooltips_scaler.config.cloth_size, 1);
	}

	@Redirect(method = "renderHeldItemTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/hud/InGameHud;scaledWidth:I"))
	private int modifyWidth(InGameHud instance) {
		return (int) (scaledWidth / Tooltips_scaler.config.cloth_size);
	}

	@Redirect(method = "renderHeldItemTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/hud/InGameHud;scaledHeight:I"))
	private int modifyHeight(InGameHud instance) {
		return (int) (scaledHeight / Tooltips_scaler.config.cloth_size);
	}
	@Redirect(method = "renderHeldItemTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/hud/InGameHud;heldItemTooltipFade:I"))
	private int modifyFade(InGameHud instance){
		if(Tooltips_scaler.config.cloth_permanent_fade){
			return (int) Tooltips_scaler.config.cloth_fade_size;
		}
		else return heldItemTooltipFade;
	}

	@Inject(method = "renderHeldItemTooltip", at = @At("TAIL"))
	private void injectTail(DrawContext context, CallbackInfo ci) {
		context.getMatrices().pop();
	}
}