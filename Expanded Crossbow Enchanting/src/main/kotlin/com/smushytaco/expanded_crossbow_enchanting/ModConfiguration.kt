package com.smushytaco.expanded_crossbow_enchanting
import io.wispforest.owo.config.annotation.Config
import io.wispforest.owo.config.annotation.Modmenu
@Modmenu(modId = ExpandedCrossbowEnchanting.MOD_ID)
@Config(name = ExpandedCrossbowEnchanting.MOD_ID, wrapperName = "ModConfig")
@Suppress("UNUSED")
class ModConfiguration {
    @JvmField
    var piercingAndMultishotCanBeMixed = true
    @JvmField
    var canUseLootingOnCrossbow = true
    @JvmField
    var canUseInfinityOnCrossbow = true
    @JvmField
    var canUseFlameOnCrossbow = true
    @JvmField
    var canUsePowerOnCrossbow = true
    @JvmField
    var canUsePunchOnCrossbow = true
}