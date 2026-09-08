package net.greenjab.jabsfixedworldandui.client.mixin.font;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilScreen.class)
public abstract class AnvilScreenMixin {

    @Shadow private EditBox name;

    @Inject(method = "subInit", at = @At(value = "TAIL"))
    private void nonFormatAnvil(CallbackInfo ci) {
        name.addFormatter(this::formatChat);
    }

    @Unique private FormattedCharSequence formatChat(final String text, final int offset) {
        return FormattedCharSequence.forward(text, Style.EMPTY);
    }
}
