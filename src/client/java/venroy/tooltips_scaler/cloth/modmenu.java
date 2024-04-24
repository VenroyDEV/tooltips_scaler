package venroy.tooltips_scaler.cloth;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

    @Environment(EnvType.CLIENT)
    public class modmenu implements ModMenuApi {

        @Override
        public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return parent -> AutoConfig.getConfigScreen(cloth_config.class, parent).get();
        }
    }

