package net.greenjab.jabsfixedworldandui.registries;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.greenjab.jabsfixedworldandui.other.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BiomeAdditions {

    public static void registerBiomeAdds() {
        System.out.println("register BiomeAdds");

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_OVERWORLD), GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_EMERALD);
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_EMERALD), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_emerald"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_COPPER), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_copper_extra"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_GOLD), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_terracotta"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_GOLD), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_gold_extra"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_LAPIS), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_lapis_extra"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_LAPIS), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_sandstone"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_COAL), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_coal_extra"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_COAL), GenerationStep.Decoration.VEGETAL_DECORATION, of("vines_underground_extra"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_COAL), GenerationStep.Decoration.VEGETAL_DECORATION, of("vines_underground_extra2"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_COAL), GenerationStep.Decoration.VEGETAL_DECORATION, of("vines_underground_extra3"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_IRON), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_mossy_cobblestone"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_IRON), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_iron_extra"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_REDSTONE), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_redstone_extra"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_REDSTONE), GenerationStep.Decoration.VEGETAL_DECORATION, of("mushrooms_extra"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_REDSTONE), GenerationStep.Decoration.VEGETAL_DECORATION, of("mushrooms_extra2"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_NETHER), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_ancient_debris_lava"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.HAS_BONUS_DEBRIS), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_ancient_debris_extra"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_FROZEN), GenerationStep.Decoration.UNDERGROUND_ORES, of("ore_packed_ice"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_FROZEN), GenerationStep.Decoration.VEGETAL_DECORATION, of("cave_snow"));

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_PALE), GenerationStep.Decoration.VEGETAL_DECORATION, of("cave_hanging_moss"));
        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.IS_PALE), GenerationStep.Decoration.VEGETAL_DECORATION, of("cave_pale_carpet"));
    }

    public static ResourceKey<PlacedFeature> of(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, JabsFixedWorldAndUI.id(id));
    }
}
