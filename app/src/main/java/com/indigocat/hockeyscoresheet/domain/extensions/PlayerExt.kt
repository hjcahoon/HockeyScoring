package com.indigocat.hockeyscoresheet.domain.extensions

import android.content.Context
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.domain.model.Player


fun Player.getNumberAndName(context: Context) : String {
    return if (this.number != null) {
        context.getString(R.string.player_name_and_number, this.number, this.givenName.first(), this.familyName)
    } else context.getString(R.string.player_name, this.givenName.first(), this.familyName)
}

fun Player.getNumberAndFamilyName(context: Context) : String {
    return if (this.number != null) {
        context.getString(R.string.player_family_name_and_number, this.number, this.familyName)
    } else context.getString(R.string.player_family_name, this.familyName)
}
