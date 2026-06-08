package net.greenjab.jabsfixedworldandui;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JabsFixedWorldAndUI implements ModInitializer {
	public static final String MOD_ID = "jabsfixedcombat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}