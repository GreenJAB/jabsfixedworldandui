package net.greenjab.jabsfixedworldandui.client.mixin.ui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractRecipeBookScreen.class)
public abstract class AbstractRecipeBookScreenMixin {

@Inject(method = "lambda$initButton$0", at = @At("TAIL"))
    private void addTagToRecipeButton(Button button, CallbackInfo ci) {
        button.setMessage(Component.translatable("jabsfixedworldandui:recipe_book"));
    }
}
