package net.greenjab.jabsfixedworldandui.registries;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.serialization.Codec;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.gamerules.*;

import java.util.function.ToIntFunction;

public class GameRuleRegistry {
    public static final GameRuleCategory JABSFIXEDWORLDANDUI = GameRuleCategory.register(JabsFixedWorldAndUI.id("aae_jabsfixedworldandui"));



    public static void registerGameRules() {
        System.out.println("register GameRules");

    }

    private static GameRule<Boolean> registerBoolean(String name, boolean defaultValue) {
        return register(name, GameRuleType.BOOL, BoolArgumentType.bool(), Codec.BOOL, defaultValue,
                FeatureFlagSet.of(), GameRuleTypeVisitor::visitBoolean,value -> value ? 1 : 0);
    }

    private static GameRule<Integer> registerInteger(
            final String id, final int defaultValue, final int min, final int max) {
        return register(id, GameRuleType.INT, IntegerArgumentType.integer(min, max), Codec.intRange(min, max),
                defaultValue, FeatureFlagSet.of(), GameRuleTypeVisitor::visitInteger, i -> i);
    }

    private static <T> GameRule<T> register(String name, GameRuleType type,
                                            ArgumentType<T> argumentType, Codec<T> codec, T defaultValue, FeatureFlagSet requiredFeatures,
                                            GameRules.VisitorCaller<T> acceptor, ToIntFunction<T> commandResultSupplier) {
        return Registry.register(BuiltInRegistries.GAME_RULE, JabsFixedWorldAndUI.id(name),
                new GameRule<>(GameRuleRegistry.JABSFIXEDWORLDANDUI, type, argumentType, acceptor, codec, commandResultSupplier, defaultValue, requiredFeatures));
    }
}
