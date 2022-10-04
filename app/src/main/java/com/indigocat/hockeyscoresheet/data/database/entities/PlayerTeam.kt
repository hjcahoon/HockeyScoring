package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerTeam(
    @PrimaryKey
    val id: String,
    val teamId: String,
    val playerId: String
)
