package net.greenjab.jabsfixedworldandui;

import net.fabricmc.api.ModInitializer;

import net.greenjab.jabsfixedworldandui.registries.BiomeAdditions;
import net.greenjab.jabsfixedworldandui.registries.ComponentRegistry;
import net.greenjab.jabsfixedworldandui.registries.LootTableRegistry;
import net.greenjab.jabsfixedworldandui.registries.TrimMaterialsRegistry;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class JabsFixedWorldAndUI implements ModInitializer {
	public static final String NAMESPACE = "jabsfixedworldandui";
	public static final String MOD_NAME = "Jabs Fixed World And UI";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAMESPACE);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing " + MOD_NAME);

		ComponentRegistry.registerComponent();
		LootTableRegistry.registerLootTable();
		TrimMaterialsRegistry.registerTrimMaterials();
		BiomeAdditions.registerBiomeAdds();
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
}