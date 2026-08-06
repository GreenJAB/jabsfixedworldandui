package net.greenjab.jabsfixedworldandui.other;

import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    public static final TagKey<Biome> IS_OVERWORLD = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("is_overworld"));
    public static final TagKey<Biome> IS_NETHER = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("is_nether"));
    public static final TagKey<Biome> IS_FROZEN = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("is_frozen"));
    public static final TagKey<Biome> IS_PALE = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("is_pale"));
    public static final TagKey<Biome> HAS_BONUS_COAL = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_coal"));
    public static final TagKey<Biome> HAS_BONUS_COPPER = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_copper"));
    public static final TagKey<Biome> HAS_BONUS_IRON = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_iron"));
    public static final TagKey<Biome> HAS_BONUS_GOLD = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_gold"));
    public static final TagKey<Biome> HAS_BONUS_EMERALD = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_emerald"));
    public static final TagKey<Biome> HAS_BONUS_LAPIS = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_lapis"));
    public static final TagKey<Biome> HAS_BONUS_REDSTONE = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_redstone"));
    public static final TagKey<Biome> HAS_BONUS_DEBRIS = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("has_bonus_debris"));

    public static final TagKey<Item> HAS_WAYPOINTS = TagKey.create(Registries.ITEM, JabsFixedWorldAndUI.id("has_waypoints"));

}
