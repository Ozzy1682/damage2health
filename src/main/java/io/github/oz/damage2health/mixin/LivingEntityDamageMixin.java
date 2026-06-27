package io.github.oz.damage2health.mixin;

import io.github.oz.damage2health.Damage2Health;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityDamageMixin {

    @Inject(method = "damage", at = @At("HEAD"))
    private void damage2health$onDamage(
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        LivingEntity entity = (LivingEntity) (Object) this;

        // Ignore the client-side prediction.
        if (entity.getWorld().isClient()) {
            return;
        }

        Damage2Health.LOGGER.info(
                "{} is about to take {} damage",
                entity.getName().getString(),
                amount
        );
    }
}
