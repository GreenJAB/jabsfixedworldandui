package net.greenjab.jabsfixedworldandui.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.greenjab.jabsfixedworldandui.registries.GameRuleRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.gamerules.GameRules;

public class GameRuleStatus {
    public boolean disable_f3;

    public GameRuleStatus(){
    }

    public void updateRules(GameRules rules) {
        this.disable_f3 = rules.get(GameRuleRegistry.DISABLE_F3);
    }

    void toPacket(FriendlyByteBuf buf) {
        buf.writeBoolean(disable_f3);
    }

    static GameRuleStatus fromPacket(FriendlyByteBuf buf) {
        GameRuleStatus p = new GameRuleStatus();
        p.disable_f3 = buf.readBoolean();
        return p;
    }

    public static void sendData(MinecraftServer server) {
        JabsFixedWorldAndUI.gameRules.updateRules(server.getGameRules());
        GameRulePayload payload = new GameRulePayload(JabsFixedWorldAndUI.gameRules);
        server.getPlayerList().getPlayers().forEach(player -> ServerPlayNetworking.send(player, payload));
    }
}
