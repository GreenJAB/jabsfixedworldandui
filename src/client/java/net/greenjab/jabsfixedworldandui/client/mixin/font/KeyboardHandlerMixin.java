package net.greenjab.jabsfixedworldandui.client.mixin.font;

import net.greenjab.jabsfixedworldandui.client.HotbarCycler;
import net.greenjab.jabsfixedworldandui.client.JabsFixedWorldAndUIClient;
import net.minecraft.client.KeyboardHandler;
import net.minecraft.client.input.KeyEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public abstract class KeyboardHandlerMixin {

    @Inject(method = "keyPress", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/KeyMapping;matches(Lnet/minecraft/client/input/KeyEvent;)Z", ordinal = 0),
            cancellable = true
    )
    private void toggleFontHelper(long handle, int action, KeyEvent event, CallbackInfo ci) {
        if (HotbarCycler.getFontLegendKeyBinding().matches(event)) {
            JabsFixedWorldAndUIClient.fontLegend =!JabsFixedWorldAndUIClient.fontLegend;
            ci.cancel();
        }
    }
}
