package net.greenjab.jabsfixedworldandui.client.mixin.ui;

import net.greenjab.jabsfixedworldandui.client.JabsFixedWorldAndUIClient;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VideoSettingsScreen.class)
public abstract class VideoSettingsScreenMixin {

    @Inject(method = "displayOptions", at = @At("RETURN"), cancellable = true)
    private static void armorHudOption(Options options, CallbackInfoReturnable<OptionInstance<?>[]> cir){
        OptionInstance<?>[] oldOptions = cir.getReturnValue();
        OptionInstance<?>[] newOptions = new OptionInstance[cir.getReturnValue().length+2];
        System.arraycopy(oldOptions, 0, newOptions, 0, oldOptions.length);
        newOptions[oldOptions.length]=JabsFixedWorldAndUIClient.itemArmorHud;
        newOptions[oldOptions.length+1]=JabsFixedWorldAndUIClient.jabsFixedFog;
        cir.setReturnValue(newOptions);
    }
}
