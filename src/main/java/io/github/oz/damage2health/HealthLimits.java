package io.github.oz.damage2health;

public final class HealthLimits {

    /**
     * Vanilla Minecraft's maximum health.
     * 1024 HP = 512 hearts.
     */
    public static final double VANILLA_MAX_HEALTH = 1024.0;

    private HealthLimits() {
    }

    public static double getMaximumHealth() {

        if (Damage2Health.ATTRIBUTE_FIX_INSTALLED) {
            return Double.MAX_VALUE;
        }

        return VANILLA_MAX_HEALTH;
    }
}
