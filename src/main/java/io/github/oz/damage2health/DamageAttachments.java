package io.github.oz.damage2health.data;

import com.mojang.serialization.Codec;
import io.github.oz.damage2health.Damage2Health;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.util.Identifier;

public final class DamageAttachments {

    private DamageAttachments() {
    }

    public static final AttachmentType<Float> TOTAL_DAMAGE =
            AttachmentRegistry.create(
                    Identifier.of(Damage2Health.MOD_ID, "total_damage"),
                    builder -> builder
                            .initializer(() -> 0.0F)
                            .persistent(Codec.FLOAT)
                            .copyOnDeath()
            );
}
