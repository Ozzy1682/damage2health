package io.github.oz.damage2health.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

public final class ConfigManager {

    private ConfigManager() {
    }

    public static Damage2HealthConfig getConfig() {
        return AutoConfig.getConfigHolder(Damage2HealthConfig.class).getConfig();
    }

    public static void save() {
        AutoConfig.getConfigHolder(Damage2HealthConfig.class).save();
    }

    public static void load() {
        AutoConfig.getConfigHolder(Damage2HealthConfig.class).load();
    }
}
