package io.github.oz.damage2health;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;

public final class DamageManager {

    private DamageManager() {
    }

    public static void onDamage(DamageSource source, LivingEntity target, float actualDamage) {

        if (actualDamage <= 0.0F) {
            return;
        }

        Entity attacker = source.getAttacker();

        if (!(attacker instanceof ServerPlayerEntity serverPlayer)) {
            return;
        }

        // Never award health from PvP.
        if (target instanceof ServerPlayerEntity) {
            return;
        }

        PlayerDamageTracker.add(serverPlayer, actualDamage);

        HealthManager.updatePlayerHealth(serverPlayer);

        Damage2Health.LOGGER.info(
                "{} dealt {} actual damage (total: {})",
                serverPlayer.getName().getString(),
                actualDamage,
                PlayerDamageTracker.get(serverPlayer)
        );
    }
}
