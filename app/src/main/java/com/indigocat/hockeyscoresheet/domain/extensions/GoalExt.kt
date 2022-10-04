package com.indigocat.hockeyscoresheet.domain.extensions

import android.content.Context
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.domain.model.Goal
import com.indigocat.hockeyscoresheet.domain.model.PlayType

fun Goal.getAbbreviatedType(context: Context): String {
    return when(this.goalType) {
        PlayType.EvenStrength -> context.getString(R.string.even_strength_abbv)
        PlayType.PowerPlay -> context.getString(R.string.power_play_abbv)
        PlayType.EmptyNet -> context.getString(R.string.empty_net_abbv)
        PlayType.ShortHanded -> context.getString(R.string.short_handed_abbv)
        PlayType.FiveOnThree -> context.getString(R.string.power_play_abbv)
        else -> ""
    }
}
