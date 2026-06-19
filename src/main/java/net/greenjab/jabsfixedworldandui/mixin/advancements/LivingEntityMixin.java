package net.greenjab.jabsfixedworldandui.mixin.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "die", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;awardKillScore(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;)V"))
    private void giveTntAdvancement(DamageSource source, CallbackInfo ci) {
        if (source.getDirectEntity() instanceof PrimedTnt) {
            if ((LivingEntity)(Object)this instanceof Monster) {
                Entity player = source.getEntity();
                if (player != null) {
                    if (player instanceof ServerPlayer SPE) {
                        CriteriaTriggers.CONSUME_ITEM.trigger(SPE, Items.TNT.getDefaultInstance());
                    }
                }
            }
        }
    }
}
