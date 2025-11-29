package com.smushytaco.expanded_crossbow_enchanting.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_crossbow_enchanting.ExpandedCrossbowEnchanting;
import net.minecraft.core.Holder;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Set;
@Mixin(Enchantment.class)
public abstract class CrossbowModification {
    @ModifyReturnValue(method = "canEnchant", at = @At("RETURN"))
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
    @ModifyReturnValue(method = "areCompatible", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, Holder<Enchantment> first, Holder<Enchantment> second) { return original || ExpandedCrossbowEnchanting.INSTANCE.getConfig().getPiercingAndMultishotCanBeMixed() && ExpandedCrossbowEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.MULTISHOT, Enchantments.PIERCING)); }
}