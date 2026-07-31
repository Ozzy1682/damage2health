package io.github.oz.damage2health;

import io.github.oz.damage2health.data.DamageAttachments;
import net.minecraft.server.network.ServerPlayerEntity;

public final class PlayerDamageTracker {

    private PlayerDamageTracker() {
    }

    public static float get(ServerPlayerEntity player) {
        Float damage = player.getAttached(DamageAttachments.TOTAL_DAMAGE);
        return damage != null ? damage : 0.0F;
    }

    public static void add(ServerPlayerEntity player, float amount) {
        float current = get(player);

        player.setAttached(
                DamageAttachments.TOTAL_DAMAGE,
                current + amount
        );
    }

    public static void reset(ServerPlayerEntity player) {
        player.setAttached(
                DamageAttachments.TOTAL_DAMAGE,
                0.0F
        );
    }
}
