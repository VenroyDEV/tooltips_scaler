package venroy.tooltips_scaler.mixin.client;



import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class Tooltips_scalerClient {
	@Shadow private int scaledWidth;
	@Shadow private int scaledHeight;

	@Inject(method = "renderHeldItemTooltip", at = @At("HEAD"))
	private void injectHead(DrawContext context, CallbackInfo ci) {
		context.getMatrices().push();
		context.getMatrices().scale(2, 2, 1); //fuck around and add sliders
	}

	@Redirect(method = "renderHeldItemTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/hud/InGameHud;scaledWidth:I"))
	private int modifyWidth(InGameHud instance) {
		return scaledWidth / 2;
	}

	@Redirect(method = "renderHeldItemTooltip", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/hud/InGameHud;scaledHeight:I"))
	private int modifyHeight(InGameHud instance) {
		return scaledHeight / 2;
	}

	@Inject(method = "renderHeldItemTooltip", at = @At("TAIL"))
	private void injectTail(DrawContext context, CallbackInfo ci) {
		context.getMatrices().pop();
	}
}