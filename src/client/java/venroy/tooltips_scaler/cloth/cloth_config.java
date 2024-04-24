package venroy.tooltips_scaler.cloth;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "tooltips_scaler")

public class cloth_config implements ConfigData {

    public float cloth_size = 1;
    public boolean cloth_permanent_fade = false;
    @ConfigEntry.BoundedDiscrete(max = 10, min= 1)
    public int cloth_fade_size = 10;


}



