package io.github.oz.damage2health.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.oz.damage2health.Damage2Health;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ConfigManager {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private static final Path CONFIG_PATH =
            FabricLoader.getInstance()
                    .getConfigDir()
                    .resolve("damage2health.json");

    private static Damage2HealthConfig config =
            new Damage2HealthConfig();

    private ConfigManager() {
    }

    public static Damage2HealthConfig getConfig() {
        return config;
    }

    public static void load() {

        Damage2Health.LOGGER.info("Config path: {}", CONFIG_PATH.toAbsolutePath());

        if (!Files.exists(CONFIG_PATH)) {

            Damage2Health.LOGGER.info("Config does not exist. Creating default config...");

            save();

            return;
        }

        Damage2Health.LOGGER.info("Loading config...");

        try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {

            Damage2HealthConfig loaded =
                    GSON.fromJson(reader, Damage2HealthConfig.class);

            if (loaded != null) {
                config = loaded;
            }

            Damage2Health.LOGGER.info("Config loaded successfully.");

        } catch (IOException e) {

            Damage2Health.LOGGER.error(
                    "Failed to load config!",
                    e
            );
        }
    }

    public static void save() {

        try {

            Files.createDirectories(CONFIG_PATH.getParent());

            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {

                GSON.toJson(config, writer);
            }

            Damage2Health.LOGGER.info("Config saved to {}", CONFIG_PATH.toAbsolutePath());

        } catch (IOException e) {

            Damage2Health.LOGGER.error(
                    "Failed to save config!",
                    e
            );
        }
    }
}
