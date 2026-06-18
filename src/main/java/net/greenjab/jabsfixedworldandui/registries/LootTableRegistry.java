package net.greenjab.jabsfixedworldandui.registries;

import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

public class LootTableRegistry {

    public static final ResourceKey<LootTable> WOODLAND_MANSION_COMMON = registerLoot_Table("chests/woodland_mansion_common");
    public static final ResourceKey<LootTable> WOODLAND_MANSION_POT = registerLoot_Table("chests/woodland_mansion_pot");

    private static ResourceKey<LootTable> registerLoot_Table(String id) {
        return registerLootTable(ResourceKey.create(Registries.LOOT_TABLE, JabsFixedWorldAndUI.id(id)));
    }
    private static ResourceKey<LootTable> registerLootTable(ResourceKey<LootTable> key) {
        if (BuiltInLootTables.LOCATIONS.add(key)) {
            return key;
        } else {
            throw new IllegalArgumentException(key.identifier() + " is already a registered built-in loot table");
        }
    }

    public static void registerLootTable() {
        System.out.println("register LootTables");
    }
}
