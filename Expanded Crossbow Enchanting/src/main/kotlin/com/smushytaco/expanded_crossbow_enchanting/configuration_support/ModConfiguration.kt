package com.smushytaco.expanded_crossbow_enchanting.configuration_support
import com.smushytaco.expanded_crossbow_enchanting.ExpandedCrossbowEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExpandedCrossbowEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes you'll be able to mix Piercing and Multishot on a crossbow. If set to no you won't be able to.")
    val piercingAndMultishotCanBeMixed = true
    @Comment("Default value is yes. If set to yes you'll be able to use Looting on a crossbow. If set to no you won't be able to.")
    val canUseLootingOnCrossbow = true
    @Comment("Default value is yes. If set to yes you'll be able to use Infinity on a crossbow. If set to no you won't be able to.")
    val canUseInfinityOnCrossbow = true
    @Comment("Default value is yes. If set to yes you'll be able to use Flame on a crossbow. If set to no you won't be able to.")
    val canUseFlameOnCrossbow = true
    @Comment("Default value is yes. If set to yes you'll be able to use Power on a crossbow. If set to no you won't be able to.")
    val canUsePowerOnCrossbow = true
    @Comment("Default value is yes. If set to yes you'll be able to use Punch on a crossbow. If set to no you won't be able to.")
    val canUsePunchOnCrossbow = true
}