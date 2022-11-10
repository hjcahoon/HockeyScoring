package com.indigocat.hockeyscoresheet.ui.extensions

import android.content.Context
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.ui.extensions.DateExt.Companion.ONE_DAY_IN_MILLIS
import com.indigocat.hockeyscoresheet.ui.extensions.DateExt.Companion.ONE_HOUR_IN_MILLIS
import com.indigocat.hockeyscoresheet.ui.extensions.DateExt.Companion.getTimeFormatter
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

fun getTodayWithTimeString(): String {
    return getTimeFormatter().format(Date())
}

fun getPrettyDate(input: String): String? {
    val date = DateExt.getDateFormatter().parse(input)

    return date?.let { DateExt.getPrettyTimeFormatter().format(it.time + 15 * ONE_HOUR_IN_MILLIS ) }
}

fun getTomorrowString(): String {
    return DateExt.getDateFormatter().format(Date().time + ONE_DAY_IN_MILLIS)
}

fun getYesterdayString(): String {
    return DateExt.getDateFormatter().format(Date().time - ONE_DAY_IN_MILLIS)
}

class DateExt {
    companion object {
        const val ONE_HOUR_IN_MILLIS = 1000 * 60 * 60
        const val ONE_DAY_IN_MILLIS = ONE_HOUR_IN_MILLIS * 24
        private var dateFormatter: SimpleDateFormat? = null
        private var timeFormatter: SimpleDateFormat? = null
        private var prettyTimeFormatter: SimpleDateFormat? = null

        fun getDateFormatter(): DateFormat {
            if (dateFormatter == null) {
                dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            }
            return dateFormatter!!
        }

        fun getTimeFormatter(): DateFormat {
            if (timeFormatter == null) {
                timeFormatter = SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.getDefault())
            }
            return timeFormatter!!
        }

        fun getPrettyTimeFormatter(): DateFormat {
            if (prettyTimeFormatter == null) {
                prettyTimeFormatter = SimpleDateFormat("E MMM dd h:mma", Locale.getDefault())
            }
            return prettyTimeFormatter!!
        }
    }
}


