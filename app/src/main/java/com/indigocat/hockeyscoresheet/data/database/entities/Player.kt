package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey
    val id: String,
    val givenName: String? = null,
    val familyName: String? = null,
    val number: Int?,
    val position: String?
)
