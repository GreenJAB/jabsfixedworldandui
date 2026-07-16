package net.greenjab.jabsfixedworldandui.mixin.other;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.greenjab.jabsfixedworldandui.other.Networking;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {
    @Inject(method = "tickServer", at = @At("RETURN"))
    private void loadWorld(CallbackInfo ci) {
        MinecraftServer SW = (MinecraftServer)(Object) this;
        synchronized (Networking.SERVER_LOCK) {
            JabsFixedWorldAndUI.SERVER = SW;
            Networking.SERVER_LOCK.notifyAll();
        }
    }
}
