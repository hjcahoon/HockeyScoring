package com.indigocat.hockeyscoresheet.ui.extensions

import android.content.Context
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.ui.extensions.DateExt.Companion.ONE_DAY
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun Int.timeInPeriod(context: Context) : String {
    val minutes = this / 60
    val seconds = this % 60
    return context.getString(R.string.time_in_period, minutes, seconds)
}

fun getTodayString(): String {
    return DateExt.getDateFormatter().format(Date())
}

fun getTomorrowString(): String {
    return DateExt.getDateFormatter().format(Date().time + ONE_DAY)
}

fun getYesterdayString(): String {
    return DateExt.getDateFormatter().format(Date().time - ONE_DAY)
}

class DateExt {
    companion object {
        const val ONE_DAY = 1000 * 60 * 60 * 24
        private var dateFormatter: SimpleDateFormat? = null

        fun getDateFormatter(): DateFormat {
            if (dateFormatter == null) {
                dateFormatter = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
            }
            return dateFormatter!!
        }
    }
}


