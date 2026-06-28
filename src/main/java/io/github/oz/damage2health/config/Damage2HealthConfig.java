package io.github.oz.damage2health.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

@Config(name = "damage2health")
public class Damage2HealthConfig implements ConfigData {

    /*
     * General
     */

    public double damageMultiplier = 1.0;

    public double startingHealth = 20.0;

    /*
     * Combat
     */

    public boolean allowPvP = false;

    public boolean allowProjectileDamage = true;

    public boolean allowIndirectDamage = true;

    /*
     * Compatibility
     */

    public boolean showAttributeFixWarning = true;

    public boolean requireAttributeFixForUnlimitedHealth = true;

    public double vanillaHealthCap = 1024.0;

    /*
     * Display
     */

    public double displayedHealthCap = 1024.0;
}
