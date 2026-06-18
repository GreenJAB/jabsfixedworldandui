package net.greenjab.jabsfixedworldandui.client.mixin.ui;

import net.greenjab.jabsfixedworldandui.client.CustomContainerTextureHolder;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AbstractContainerScreen.class)
public class CustomContainerTextureMixin implements CustomContainerTextureHolder {

    @Unique
    private String jabsfixedworldandui$customTexture;

    @Override
    public void jabsfixedworldandui$setCustomTexture(String texture) {
        this.jabsfixedworldandui$customTexture = texture;
    }

    @Override
    public String jabsfixedworldandui$getCustomTexture() {
        return jabsfixedworldandui$customTexture;
    }
}
