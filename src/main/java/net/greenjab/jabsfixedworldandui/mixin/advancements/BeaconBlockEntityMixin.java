package net.greenjab.jabsfixedworldandui.mixin.advancements;

import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntityMixin {

    @Inject(method = "applyEffects", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;addEffect(Lnet/minecraft/world/effect/MobEffectInstance;)Z", ordinal = 0))
    private static void ModifyBeaconEffects(Level level, BlockPos worldPosition, int levels, @Nullable Holder<MobEffect> primaryPower,
                                            @Nullable Holder<MobEffect> secondaryPower, CallbackInfo ci, @Local Player player) {
        if (!FabricLoader.getInstance().isModLoaded("jabsfixedcombat")) {
            if (levels>=4) {
                if (player instanceof ServerPlayer SPE) CriteriaTriggers.CONSUME_ITEM.trigger(SPE, Items.BEACON.getDefaultInstance());
            }
        }
    }
}
