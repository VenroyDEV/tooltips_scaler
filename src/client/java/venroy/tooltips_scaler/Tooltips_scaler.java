package venroy.tooltips_scaler;

import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import venroy.tooltips_scaler.cloth.cloth_config;

public class Tooltips_scaler implements ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("tooltips_scaler");
	public static cloth_config config;

	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		AutoConfig.register(cloth_config.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(cloth_config.class).getConfig();
		LOGGER.info("Hello Fabric world!");
	}
}