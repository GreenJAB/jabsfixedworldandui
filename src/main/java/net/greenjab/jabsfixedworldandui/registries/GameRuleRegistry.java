package net.greenjab.jabsfixedworldandui.registries;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.serialization.Codec;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.gamerules.*;

import java.util.function.ToIntFunction;

public class GameRuleRegistry {
    public static final GameRuleCategory JABSFIXEDWORLDANDUI = GameRuleCategory.register(JabsFixedWorldAndUI.id("aae_jabsfixedworldandui"));

    //public static GameRule<Boolean> BIOME_ORES;

    public static void registerGameRules() {
        System.out.println("register GameRules");
        //BIOME_ORES = registerBooleanRule("biome_ores", JABSFIXEDWORLDANDUI, true);
    }

    private static GameRule<Boolean> registerBooleanRule(String name, GameRuleCategory category, boolean defaultValue) {
        return register(name, category, GameRuleType.BOOL, BoolArgumentType.bool(), Codec.BOOL, defaultValue,
                FeatureFlagSet.of(), GameRuleTypeVisitor::visitBoolean, value -> value ? 1 : 0);
    }

    private static <T> GameRule<T> register( String name, GameRuleCategory category, GameRuleType type,
            ArgumentType<T> argumentType, Codec<T> codec, T defaultValue,  FeatureFlagSet requiredFeatures,
            GameRules.VisitorCaller<T> acceptor, ToIntFunction<T> commandResultSupplier) {
        return Registry.register(BuiltInRegistries.GAME_RULE, JabsFixedWorldAndUI.id(name),
                new GameRule<>(category, type, argumentType, acceptor, codec, commandResultSupplier, defaultValue, requiredFeatures));
    }
}
