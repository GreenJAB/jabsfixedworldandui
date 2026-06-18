package net.greenjab.jabsfixedworldandui.other;

import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;

public class ModTags {
    public static final TagKey<Biome> IS_FROZEN = TagKey.create(Registries.BIOME, JabsFixedWorldAndUI.id("is_frozen"));
    public static final TagKey<Item> HAS_WAYPOINTS = TagKey.create(Registries.ITEM, JabsFixedWorldAndUI.id("has_waypoints"));

}
