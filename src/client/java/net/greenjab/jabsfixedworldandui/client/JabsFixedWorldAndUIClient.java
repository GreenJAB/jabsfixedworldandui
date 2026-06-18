package net.greenjab.jabsfixedworldandui.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.network.chat.Component;

public class JabsFixedWorldAndUIClient implements ClientModInitializer {
	public static float paleGardenFog = 0f;
	public static float voidFog = 0f;
	public static OptionInstance<Boolean> newArmorHud = OptionInstance.createBoolean("options.newArmorHud", true);
	public static OptionInstance<Boolean> fog_21_6 = OptionInstance.createBoolean("options.fog_21_6", true);

	@Override
	public void onInitializeClient() {
		HotbarCycler.register();

		FabricLoader.getInstance().getModContainer("jabsfixedworldandui").ifPresent(modContainer -> {
			ResourceManagerHelper.registerBuiltinResourcePack(
					JabsFixedWorldAndUI.id( "green_tweaks"),
					modContainer,
					Component.translatable("jabsfixedworldandui.green_tweaks"),
					ResourcePackActivationType.NORMAL
			);
			ResourceManagerHelper.registerBuiltinResourcePack(
					JabsFixedWorldAndUI.id( "recolourful_containers"),
					modContainer,
					Component.translatable("jabsfixedworldandui.recolourful_containers"),
					ResourcePackActivationType.NORMAL
			);
		});
	}
	public static boolean usingCustomContainers() {
		return (Minecraft.getInstance().getResourcePackRepository().getSelectedPacks().stream().anyMatch(pack -> pack.location().id().toLowerCase().contains("recolourful_containers")));
	}
}