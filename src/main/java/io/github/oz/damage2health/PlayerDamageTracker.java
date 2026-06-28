package io.github.oz.damage2health;

import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PlayerDamageTracker {

    private static final Map<UUID, Float> DAMAGE = new HashMap<>();

    private PlayerDamageTracker() {
    }

    public static float get(ServerPlayerEntity player) {
        return DAMAGE.getOrDefault(player.getUuid(), 0.0F);
    }

    public static void add(ServerPlayerEntity player, float amount) {
        DAMAGE.merge(player.getUuid(), amount, Float::sum);
    }

    public static void reset(ServerPlayerEntity player) {
        DAMAGE.remove(player.getUuid());
    }
}
