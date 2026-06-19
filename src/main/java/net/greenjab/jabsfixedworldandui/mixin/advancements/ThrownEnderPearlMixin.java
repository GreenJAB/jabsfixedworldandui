package net.greenjab.jabsfixedworldandui.mixin.advancements;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownEnderpearl.class)
public abstract class ThrownEnderPearlMixin {

    @Inject(
            method = "onHit", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerPlayer;teleport(Lnet/minecraft/world/level/portal/TeleportTransition;)Lnet/minecraft/server/level/ServerPlayer;"
    ))
    private void giveEnderPearlAdvancement(HitResult hitResult, CallbackInfo ci, @Local ServerPlayer player) {
        CriteriaTriggers.CONSUME_ITEM.trigger(player, Items.ENDER_PEARL.getDefaultInstance());
    }
}
