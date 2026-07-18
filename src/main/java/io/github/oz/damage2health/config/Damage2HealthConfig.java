package io.github.oz.damage2health.config;

public class Damage2HealthConfig {

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

    public double vanillaHealthCap = 1024.0;

    /*
     * Display
     */

    public double displayedHealthCap = 1024.0;
}
