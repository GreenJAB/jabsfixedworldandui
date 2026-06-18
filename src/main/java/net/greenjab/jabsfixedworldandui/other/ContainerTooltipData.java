package net.greenjab.jabsfixedworldandui.other;

import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.component.ItemContainerContents;

public record ContainerTooltipData(ItemContainerContents contents) implements TooltipComponent {
}
