package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.indigocat.hockeyscoresheet.ui.extensions.getTodayString

@Entity
data class Game(
    @PrimaryKey
    val id: String,
    val homeTeamId: String,
    val awayTeamId: String,
    val dateTime: String? = getTodayString(),
    val homeScore: Int? = null,
    val awayScore: Int? = null
)

