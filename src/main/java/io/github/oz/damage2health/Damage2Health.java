package io.github.oz.damage2health;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Damage2Health implements ModInitializer {

    public static final String MOD_ID = "damage2health";

    public static final Logger LOGGER =
            LoggerFactory.getLogger(MOD_ID);

    /**
     * True if AttributeFix is installed.
     */
    public static boolean ATTRIBUTE_FIX_INSTALLED = false;

    @Override
    public void onInitialize() {

        ATTRIBUTE_FIX_INSTALLED =
                FabricLoader.getInstance()
                        .isModLoaded("attributefix");

        if (ATTRIBUTE_FIX_INSTALLED) {

            LOGGER.info(
                    "AttributeFix detected. Unlimited max health is enabled."
            );

        } else {

            LOGGER.warn("========================================");
            LOGGER.warn("AttributeFix was NOT detected!");
            LOGGER.warn("Maximum health will be limited to vanilla.");
            LOGGER.warn("Install AttributeFix for unlimited health.");
            LOGGER.warn("========================================");
        }

        CommandRegistrationCallback.EVENT.register(
                (dispatcher, registryAccess, environment) -> {

                    Damage2HealthCommand.register(dispatcher);

                    LOGGER.info(
                            "Damage2Health commands registered."
                    );
                }
        );

        LOGGER.info("Damage2Health initialized.");
    }
}
