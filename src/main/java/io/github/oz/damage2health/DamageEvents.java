package io.github.oz.damage2health;

public final class DamageEvents {

    private DamageEvents() {
    }

    public static void register() {
        Damage2Health.LOGGER.info("DamageEvents registered!");
    }
}
