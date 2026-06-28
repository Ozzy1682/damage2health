package io.github.oz.damage2health.mixin;

import io.github.oz.damage2health.DamageManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityDamageMixin {

    @Unique
    private float damage2health$healthBeforeDamage;

    @Unique
    private DamageSource damage2health$damageSource;

    @Inject(method = "damage", at = @At("HEAD"))
    private void damage2health$storeHealth(
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.getWorld().isClient()) {
            return;
        }

        damage2health$healthBeforeDamage = entity.getHealth();
        damage2health$damageSource = source;
    }

    @Inject(method = "damage", at = @At("RETURN"))
    private void damage2health$afterDamage(
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.getWorld().isClient()) {
            return;
        }

        // Damage didn't actually happen.
        if (!cir.getReturnValue()) {
            return;
        }

        float healthAfterDamage = entity.getHealth();
        float actualDamage = damage2health$healthBeforeDamage - healthAfterDamage;

        if (actualDamage <= 0.0F) {
            return;
        }

        DamageManager.onDamage(
                damage2health$damageSource,
                entity,
                actualDamage
        );
    }
}
