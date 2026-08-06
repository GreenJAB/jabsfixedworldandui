package net.greenjab.jabsfixedworldandui.mixin.inventory;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin {

    //copyFrom
    @Inject(method = "transferInventoryXpAndScore", at = @At(value = "TAIL"))
    private void keepInventoryCraftingGrid(Player oldPlayer, CallbackInfo ci) {
        ServerPlayer SPE = (ServerPlayer) (Object)this;
        CraftingContainer craftingGrid = SPE.inventoryMenu.getCraftSlots();
        CraftingContainer craftingGridOriginal = SPE.connection.player.inventoryMenu.getCraftSlots();

        for (int i = 0; i < craftingGridOriginal.getContainerSize(); i++) {
            ItemStack itemStack = craftingGridOriginal.getItem(i);
            if (!itemStack.isEmpty()) {
                craftingGrid.setItem(i, itemStack);
            }
        }
    }
}
