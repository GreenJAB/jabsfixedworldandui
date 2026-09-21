package net.greenjab.jabsfixedworldandui.mixin.other;

import net.greenjab.jabsfixedworldandui.registries.TrimMaterialsRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public abstract class ItemsMixin {

    @ModifyArg(method="<clinit>", at = @At( value = "INVOKE", target = "Lnet/minecraft/world/item/Items;registerItem(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/item/Item$Properties;)Lnet/minecraft/world/item/Item;", ordinal = 0), slice = @Slice(from =
    @At(value = "FIELD", target = "Lnet/minecraft/references/ItemIds;COAL:Lnet/minecraft/resources/ResourceKey;", opcode = Opcodes.GETSTATIC), to =
    @At(value = "FIELD",target = "Lnet/minecraft/world/item/Items;COAL:Lnet/minecraft/world/item/Item;", opcode = Opcodes.PUTSTATIC)), index = 1)
    private static Item.Properties coalTrimMaterial(Item.Properties properties) {
        return properties.trimMaterial(TrimMaterialsRegistry.COAL);}

}
