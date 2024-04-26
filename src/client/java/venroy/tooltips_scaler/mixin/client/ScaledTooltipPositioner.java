//package venroy.tooltips_scaler.mixin.client; // Replace with your package name
//
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.client.gui.tooltip.HoveredTooltipPositioner;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.util.math.Vec2f;
//import org.joml.Vector2ic;
//
//@Environment(EnvType.CLIENT)
//public class ScaledTooltipPositioner extends HoveredTooltipPositioner{
//
//
//    private final float scaleFactor;
//
//    public ScaledTooltipPositioner(float scaleFactor) {
//        super();
//        this.scaleFactor = scaleFactor;
//    }
//
//
//    public Vec2f getPosition(MatrixStack matrices, int windowWidth, int windowHeight, int x, int y, int width, int height) {
//        // Get the original position from HoveredTooltipPositioner
//        Vec2f originalPosition = super.getPosition(matrices, windowWidth, windowHeight, x, y, width, height);
//
//        // Adjust the position based on the scaling factor
//        return new Vec2f(originalPosition.x / scaleFactor, originalPosition.y / scaleFactor);
////    }
