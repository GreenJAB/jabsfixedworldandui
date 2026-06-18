package net.greenjab.jabsfixedworldandui.mixin.structure;

import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(OceanMonumentPieces.MonumentBuilding.class)
public abstract class OceanMonumentPieceBuildingMixin {

     //TODO more testing, dont know why this was needed before
    /*@ModifyVariable(method = "postProcess", at = @At("STORE"), ordinal = 0)
    private int lowerMonument(int waterHeight) {
        return waterHeight - 25;
    }*/

    @ModifyConstant(method = "<init>(Lnet/minecraft/util/RandomSource;IILnet/minecraft/core/Direction;)V", constant = @Constant(intValue = 39))
    private static int lowerMonument2(int x) {
        return x-25;
    }

}
