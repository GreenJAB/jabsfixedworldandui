package net.greenjab.jabsfixedworldandui.mixin.other;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "addDetailsToTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/component/PatchedDataComponentMap;size()I"))
    private void addTagsTooltip(Item.TooltipContext context, TooltipDisplay display, Player player,
                                TooltipFlag tooltipFlag, Consumer<Component> builder, CallbackInfo ci) {
        ItemStack stack = (ItemStack)(Object)this;
        if (player.isCreative()) testTags(stack, builder);
    }

    @ModifyExpressionValue(method = "addDetailsToTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamaged()Z"))
    private boolean alwaysShowMaxDurability(boolean original) {
        return true;
    }

    @Unique
    private static void testTags(ItemStack stack, Consumer<Component> textConsumer) {
        BuiltInRegistries.ITEM.getTags().map(HolderSet.Named::key).forEach(tag->{
            if (stack.is(tag)) textConsumer.accept(Component.translatable("item.tags", tag.location().toString()).withStyle(ChatFormatting.DARK_AQUA));
        });
    }
}
