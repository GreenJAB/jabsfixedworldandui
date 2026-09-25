package net.greenjab.jabsfixedworldandui.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.greenjab.jabsfixedworldandui.network.*;

public class ClientSyncHandler {
    public static void init() {
        ClientPlayNetworking.registerGlobalReceiver(GameRulePayload.PACKET_ID, ClientSyncHandler::gamerule);
    }

    private static void gamerule(GameRulePayload payload, ClientPlayNetworking.Context context) {
        context.client().execute(()-> JabsFixedWorldAndUI.gameRules = payload.rules());
    }
}
