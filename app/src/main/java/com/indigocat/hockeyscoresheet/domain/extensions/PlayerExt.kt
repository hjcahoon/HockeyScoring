package com.indigocat.hockeyscoresheet.domain.extensions

import android.content.Context
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.domain.model.Player

@Suppress("MagicNumber")
fun Player.getNumberAndName(context: Context) : String {
    return if (this.number != null) {
        when (number) {
            -1 ->  context.getString(R.string.select_player)
            -99 -> context.getString(R.string.bench_penalty)
            else -> {
                context.getString(
                    R.string.player_name_and_number,
                    this.number,
                    this.givenName.first(),
                    this.familyName
                )
            }
        }
    } else context.getString(R.string.player_name, this.givenName, this.familyName)

}

@Suppress("MagicNumber")
fun Player.getNumberAndFamilyName(context: Context) : String {
    return if (this.number != null) {
        when (number) {
            -1 -> context.getString(R.string.select_player)
            -99 -> context.getString(R.string.bench_penalty)
            else -> {
                context.getString(
                    R.string.player_family_name_and_number,
                    this.number,
                    this.familyName
                )
            }
        }

    } else context.getString(R.string.player_family_name, this.familyName)
}
