package io.github.oz.damage2health;

import io.github.oz.damage2health.config.ConfigManager;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;

public final class HealthManager {

    private HealthManager() {
    }

    public static void updatePlayerHealth(ServerPlayerEntity player) {

        EntityAttributeInstance maxHealth =
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

        if (maxHealth == null) {
            return;
        }

        double startingHealth =
                ConfigManager.getConfig().startingHealth;

        double damageMultiplier =
                ConfigManager.getConfig().damageMultiplier;

        double totalDamage =
                PlayerDamageTracker.get(player) * damageMultiplier;

        double newMaxHealth =
                startingHealth + totalDamage;

        if (!Damage2Health.ATTRIBUTE_FIX_INSTALLED) {
            newMaxHealth = Math.min(
                    newMaxHealth,
                    ConfigManager.getConfig().vanillaHealthCap
            );
        }

        double oldMaxHealth = maxHealth.getBaseValue();

        maxHealth.setBaseValue(newMaxHealth);

        Damage2Health.LOGGER.info(
                "{} max health changed from {} to {}",
                player.getName().getString(),
                oldMaxHealth,
                newMaxHealth
        );
    }
}
