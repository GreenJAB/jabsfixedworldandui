package net.greenjab.jabsfixedworldandui.client.mixin.font;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.greenjab.jabsfixedworldandui.client.JabsFixedWorldAndUIClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Shadow @Final private Minecraft minecraft;

    @WrapOperation(method = "extractGui", at = @At(value = "INVOKE", target ="Lnet/minecraft/client/gui/screens/Screen;extractRenderStateWithTooltipAndSubtitles(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IIF)V"))
    private void renderFontHelper(Screen instance, GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a, Operation<Void> original){
        original.call(instance, graphics, mouseX, mouseY, a);
        if (JabsFixedWorldAndUIClient.fontLegend) {
            if (minecraft.screen instanceof BookEditScreen || minecraft.screen instanceof BookSignScreen ||
                minecraft.screen instanceof AbstractSignEditScreen || String.valueOf(minecraft.screen.getTitle()).contains("anvil"))
                graphics.blit(RenderPipelines.GUI_TEXTURED, Identifier.withDefaultNamespace("textures/gui/container/anvil_text_guide.png"), 10, 10, 0, 0, 146, 180, 146, 180);
        }
    }
}
