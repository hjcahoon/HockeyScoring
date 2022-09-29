package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val homeTeam: Int,
    val awayTeam: Int,
    val dateTime: String,
    val location: Int,
    val rink: String,
    val goals: List<Goal>,
    val penalties: List<Penalty>
)
