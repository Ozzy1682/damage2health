package io.github.oz.damage2health;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public final class Damage2HealthCommand {

    private Damage2HealthCommand() {
    }

    public static void register(
            CommandDispatcher<ServerCommandSource> dispatcher
    ) {
        dispatcher.register(
                literal("damage2health")

                        // /damage2health test
                        .then(
                                literal("test")
                                        .executes(context -> {

                                            context.getSource().sendFeedback(
                                                    () -> Text.literal(
                                                            "Damage2Health command system is working."
                                                    ),
                                                    false
                                            );

                                            return 1;
                                        })
                        )

                        // /damage2health damage
                        .then(
                                literal("damage")

                                        // /damage2health damage get
                                        .then(
                                                literal("get")
                                                        .executes(context -> {

                                                            ServerCommandSource source =
                                                                    context.getSource();

                                                            ServerPlayerEntity player =
                                                                    source.getPlayer();

                                                            float accumulatedDamage =
                                                                    PlayerDamageTracker.get(player);

                                                            source.sendFeedback(
                                                                    () -> Text.literal(
                                                                            "Damage2Health: You currently have "
                                                                                    + accumulatedDamage
                                                                                    + " HP of accumulated damage."
                                                                    ),
                                                                    false
                                                            );

                                                            return 1;
                                                        })
                                        )
                        )
        );
    }
}
