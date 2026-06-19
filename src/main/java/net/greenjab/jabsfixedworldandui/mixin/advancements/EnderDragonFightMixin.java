package net.greenjab.jabsfixedworldandui.mixin.advancements;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.dimension.end.EnderDragonFight;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.List;

@Mixin(EnderDragonFight.class)
public abstract class EnderDragonFightMixin {

    @Shadow
    private ServerLevel level;

    @Redirect(method = "tryRespawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/dimension/end/EnderDragonFight;respawnDragon(Ljava/util/List;)V"))
    private void giveRespawnDragonAdvancement(EnderDragonFight instance, List<EndCrystal> crystals){
        if (!FabricLoader.getInstance().isModLoaded("jabsfixedcombat")) {
            for (ServerPlayer serverPlayerEntity : (level)
                    .getPlayers( serverPlayerEntityx -> serverPlayerEntityx.position().horizontalDistance() < 128.0F)) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, Items.END_CRYSTAL.getDefaultInstance());
            }
        }
    }

    @Inject(method = "setDragonKilled", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/dimension/end/EnderDragonFight;spawnExitPortal(Z)V"))
    private void giveKillDragonAdvancement(EnderDragon dragon, CallbackInfo ci) {
        if (!FabricLoader.getInstance().isModLoaded("jabsfixedcombat")) {
            for (ServerPlayer serverPlayerEntity : (level)
                    .getPlayers( serverPlayerEntityx -> serverPlayerEntityx.position().horizontalDistance() < 128.0F)) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, Items.DRAGON_HEAD.getDefaultInstance());
            }
        }
    }
}
