package net.greenjab.jabsfixedworldandui.mixin.other;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.greenjab.jabsfixedworldandui.registries.TrimMaterialsRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
public abstract class ItemsMixin {

    @Shadow private static Item registerItem(ResourceKey<Item> id, Item.Properties properties) {
        throw new UnsupportedOperationException("Implemented via mixin");
    }

    @WrapOperation(method="<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Items;registerItem(Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/world/item/Item;"), slice = @Slice( from =
    @At(value = "FIELD", target = "Lnet/minecraft/references/ItemIds;COAL:Lnet/minecraft/resources/ResourceKey;", opcode = Opcodes.GETSTATIC), to =
    @At(value = "FIELD",target = "Lnet/minecraft/world/item/Items;COAL:Lnet/minecraft/world/item/Item;", opcode = Opcodes.PUTSTATIC)))
    private static Item coalTrimMaterial(ResourceKey<Item> id, Operation<Item> original) {
        return registerItem(id, new Item.Properties().trimMaterial(TrimMaterialsRegistry.COAL));}
}
