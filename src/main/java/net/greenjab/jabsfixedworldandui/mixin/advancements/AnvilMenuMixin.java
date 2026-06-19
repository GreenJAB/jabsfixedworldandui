package net.greenjab.jabsfixedworldandui.mixin.advancements;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin {

    @Inject(method = "onTake", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/Container;getItem(I)Lnet/minecraft/world/item/ItemStack;", ordinal = 0))
    private static void ModifyBeaconEffects(Player player, ItemStack carried, CallbackInfo ci) {
        if (!FabricLoader.getInstance().isModLoaded("jabsfixedenchanting")) {
            if (player instanceof ServerPlayer SPE) CriteriaTriggers.CONSUME_ITEM.trigger(SPE, Items.ANVIL.getDefaultInstance());
        }
    }
}
