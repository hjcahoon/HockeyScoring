package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.indigocat.hockeyscoresheet.domain.model.Position

@Entity
data class Player(
    @PrimaryKey
    val uid: String,
    val givenName: String?,
    val familyName: String?,
    val number: Int?,
    val position: Position?
)