package io.github.oz.damage2health;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;

public final class HealthManager {

    /**
     * Vanilla cannot properly display more than 1024 HP
     * (512 hearts) without AttributeFix.
     */
    public static final double VANILLA_MAX_HEALTH = 1024.0;

    private HealthManager() {
    }

    public static void updatePlayerHealth(ServerPlayerEntity player) {

        EntityAttributeInstance maxHealth =
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

        if (maxHealth == null) {
            return;
        }

        float totalDamage = PlayerDamageTracker.get(player);

        double oldMaxHealth = maxHealth.getBaseValue();
        double newMaxHealth = 20.0 + totalDamage;

        if (!Damage2Health.ATTRIBUTE_FIX_INSTALLED) {
            newMaxHealth = Math.min(newMaxHealth, VANILLA_MAX_HEALTH);
        }

        maxHealth.setBaseValue(newMaxHealth);

        Damage2Health.LOGGER.info(
                "{} max health changed from {} to {}",
                player.getName().getString(),
                oldMaxHealth,
                newMaxHealth
        );
    }
}
