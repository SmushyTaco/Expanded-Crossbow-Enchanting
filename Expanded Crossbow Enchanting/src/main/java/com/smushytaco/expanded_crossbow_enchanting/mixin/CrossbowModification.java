package com.smushytaco.expanded_crossbow_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_crossbow_enchanting.ExpandedCrossbowEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Set;
@Mixin(Enchantment.class)
public abstract class CrossbowModification {
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean hookIsAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (ExpandedCrossbowEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.LOOTING)) {
            if (!ExpandedCrossbowEnchanting.INSTANCE.getConfig().getCanUseLootingOnCrossbow() || !(stack.getItem() instanceof CrossbowItem)) return original;
            return true;
        } else if (ExpandedCrossbowEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.INFINITY)) {
            if (!ExpandedCrossbowEnchanting.INSTANCE.getConfig().getCanUseInfinityOnCrossbow() || !(stack.getItem() instanceof CrossbowItem)) return original;
            return true;
        } else if (ExpandedCrossbowEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.FLAME)) {
            if (!ExpandedCrossbowEnchanting.INSTANCE.getConfig().getCanUseFlameOnCrossbow() || !(stack.getItem() instanceof CrossbowItem)) return original;
            return true;
        } else if (ExpandedCrossbowEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.POWER)) {
            if (!ExpandedCrossbowEnchanting.INSTANCE.getConfig().getCanUsePowerOnCrossbow() || !(stack.getItem() instanceof CrossbowItem)) return original;
            return true;
        } else if (ExpandedCrossbowEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.PUNCH)) {
            if (!ExpandedCrossbowEnchanting.INSTANCE.getConfig().getCanUsePunchOnCrossbow() || !(stack.getItem() instanceof CrossbowItem)) return original;
            return true;
        }
        return original;
    }
    @ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second) { return original || ExpandedCrossbowEnchanting.INSTANCE.getConfig().getPiercingAndMultishotCanBeMixed() && ExpandedCrossbowEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.MULTISHOT, Enchantments.PIERCING)); }
}