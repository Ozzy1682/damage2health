package io.github.oz.damage2health;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Damage2Health implements ModInitializer {

    public static final String MOD_ID = "damage2health";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static boolean ATTRIBUTE_FIX_INSTALLED = false;

    @Override
    public void onInitialize() {

        ATTRIBUTE_FIX_INSTALLED =
                FabricLoader.getInstance().isModLoaded("attributefix");

        if (ATTRIBUTE_FIX_INSTALLED) {
            LOGGER.info("AttributeFix detected.");
            LOGGER.info("Unlimited health is enabled.");
        } else {
            LOGGER.warn("==============================================");
            LOGGER.warn("AttributeFix was NOT detected.");
            LOGGER.warn("Health will be visually limited to 512 hearts.");
            LOGGER.warn("Install AttributeFix for unlimited health.");
            LOGGER.warn("==============================================");
        }

        LOGGER.info("Damage2Health initialized.");
    }
}
