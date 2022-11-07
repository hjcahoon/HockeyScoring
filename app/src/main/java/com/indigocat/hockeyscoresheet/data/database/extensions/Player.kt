package com.indigocat.hockeyscoresheet.data.database.extensions

import com.indigocat.hockeyscoresheet.data.database.entities.Player


fun Player.toDataPlayer() : com.indigocat.hockeyscoresheet.data.api.model.Player {
    return com.indigocat.hockeyscoresheet.data.api.model.Player(
        this.id,
        this.givenName ?: "",
        this.familyName ?: "",
        this.number,
        this.position
    )
}
