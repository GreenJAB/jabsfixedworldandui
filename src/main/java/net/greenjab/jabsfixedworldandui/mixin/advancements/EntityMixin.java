package net.greenjab.jabsfixedworldandui.mixin.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.pig.Pig;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(method = "resetFallDistance", at = @At("HEAD"))
    private void giveWhenPigsFlyAdvancement(CallbackInfo ci) {
        Entity E = (Entity)(Object)this;
        if (E instanceof Pig PE) {
            if (E.fallDistance > 9.5) {
                if (PE.isVehicle()) {
                    if (PE.getControllingPassenger() instanceof ServerPlayer SPE) {
                        CriteriaTriggers.CONSUME_ITEM.trigger(SPE, Items.SADDLE.getDefaultInstance());
                    }
                }
            }
        }
    }
}
