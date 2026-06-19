package net.greenjab.jabsfixedworldandui.client.mixin.ui;

import net.fabricmc.loader.api.FabricLoader;
import net.greenjab.jabsfixedworldandui.client.JabsFixedWorldAndUIClient;
import net.greenjab.jabsfixedworldandui.client.CustomContainerTextureHolder;
import net.minecraft.client.gui.screens.inventory.AbstractMountInventoryScreen;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.equine.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMountInventoryScreen.class)
public abstract class AbstractMountInventoryScreenMixin {

    @Inject(method = "<init>", at = @At(value = "TAIL"))
    private void setUpCustomHorseUI(CallbackInfo ci) {
        AbstractMountInventoryScreen<?> AMIS = (AbstractMountInventoryScreen<?>) (Object)this;
        ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$setCustomTexture("");
        if (!JabsFixedWorldAndUIClient.usingCustomContainers()) return;

        LivingEntity entity = AMIS.getMenu().mount;
        if (entity != null) {
            if (entity instanceof Horse) {
                ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$setCustomTexture("/horse");
            } else if (entity instanceof Donkey || (entity instanceof Mule && !FabricLoader.getInstance().isModLoaded("jabsfixedtransport"))) {
                ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$setCustomTexture("/donkey");
            } else if (entity instanceof Mule) {
                    ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$setCustomTexture("/mule");
            } else if (entity instanceof Camel) {
                ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$setCustomTexture("/camel");
            } else if (entity instanceof Llama || entity instanceof TraderLlama) {
                ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$setCustomTexture("/llama");
            }
        }
    }
    @ModifyArg(method = "extractBackground", at = @At(value = "INVOKE",
                                                      target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;blit(Lcom/mojang/blaze3d/pipeline/RenderPipeline;Lnet/minecraft/resources/Identifier;IIFFIIII)V"
    ), index = 1)
    private Identifier useCustomHorseUI(Identifier texture) {
        AbstractMountInventoryScreen<?> AMIS = (AbstractMountInventoryScreen<?>) (Object)this;
        if (!((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$getCustomTexture().isEmpty())
            return Identifier.withDefaultNamespace("textures/gui/container/horse" + ((CustomContainerTextureHolder) AMIS).jabsfixedworldandui$getCustomTexture() + ".png");
        return texture;
    }
}
