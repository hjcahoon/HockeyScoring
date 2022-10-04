package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey
    val id: String,
    val homeTeam: String,
    val awayTeam: String,
    val dateTime: String,
    val location: String,
    val division: String? = null,
    val rink: String
)

