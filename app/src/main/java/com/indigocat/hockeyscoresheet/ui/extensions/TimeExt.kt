package com.indigocat.hockeyscoresheet.ui.extensions

import android.content.Context
import com.indigocat.hockeyscoresheet.R

fun Int.timeInPeriod(context: Context) : String {
    val minutes = this / 60
    val seconds = this % 60
    return context.getString(R.string.time_in_period, minutes, seconds)
}