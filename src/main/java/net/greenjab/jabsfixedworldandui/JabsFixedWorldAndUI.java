package net.greenjab.jabsfixedworldandui;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.greenjab.jabsfixedworldandui.registries.BiomeAdditions;
import net.greenjab.jabsfixedworldandui.registries.GameRuleRegistry;
import net.greenjab.jabsfixedworldandui.registries.LootTableRegistry;
import net.greenjab.jabsfixedworldandui.registries.TrimMaterialsRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class JabsFixedWorldAndUI implements ModInitializer {
	public static final String NAMESPACE = "jabsfixedworldandui";
	public static final String MOD_NAME = "Jabs Fixed World And UI";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);
	public static MinecraftServer SERVER = null;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing " + MOD_NAME);

		GameRuleRegistry.registerGameRules();
		LootTableRegistry.registerLootTable();
		TrimMaterialsRegistry.registerTrimMaterials();
		BiomeAdditions.registerBiomeAdds();

		FabricLoader.getInstance().getModContainer(NAMESPACE).ifPresent(modContainer -> {
					ResourceManagerHelper.registerBuiltinResourcePack(
							JabsFixedWorldAndUI.id("worldgen_changes"),
							modContainer,
							Component.nullToEmpty("jabsfixedworldandui.worldgen_changes"),
							ResourcePackActivationType.DEFAULT_ENABLED);
					ResourceManagerHelper.registerBuiltinResourcePack(
							JabsFixedWorldAndUI.id("structure_changes"),
							modContainer,
							Component.nullToEmpty("jabsfixedworldandui.structure_changes"),
							ResourcePackActivationType.DEFAULT_ENABLED);
		});
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(NAMESPACE, path);
	}

	public static ArrayList<ItemStack> getArmorBypass(LivingEntity entity) {
		ArrayList<ItemStack> armor = new ArrayList<>();
		armor.add(entity.equipment.get(EquipmentSlot.FEET));
		armor.add(entity.equipment.get(EquipmentSlot.LEGS));
		armor.add(entity.equipment.get(EquipmentSlot.CHEST));
		armor.add(entity.equipment.get(EquipmentSlot.HEAD));
		return armor;
	}

	public static boolean isChangesEnabled(String pack){
		if (SERVER==null) return false;
		return JabsFixedWorldAndUI.SERVER.reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, JabsFixedWorldAndUI.id(pack))) !=LootTable.EMPTY;
	}
}