package net.greenjab.jabsfixedworldandui.mixin.structure;

import net.greenjab.jabsfixedworldandui.JabsFixedWorldAndUI;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(OceanMonumentPieces.MonumentBuilding.class)
public abstract class OceanMonumentPieceBuildingMixin {

    @ModifyConstant(method = "<init>(Lnet/minecraft/util/RandomSource;IILnet/minecraft/core/Direction;)V", constant = @Constant(intValue = 39))
    private static int lowerMonument(int x) {
        if (JabsFixedWorldAndUI.isChangesEnabled("terrain")) return x-17;
        return x;
    }
}
