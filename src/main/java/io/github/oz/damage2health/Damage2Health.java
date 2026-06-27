package io.github.oz.damage2health;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Damage2Health implements ModInitializer {
	public static final String MOD_ID = "damage2health";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
public void onInitialize() {
    LOGGER.info("Damage2Health loaded!");

    DamageEvents.register();
}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
