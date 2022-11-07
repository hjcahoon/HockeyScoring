package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayerAndTeam(
    @PrimaryKey
    val id: Int,
    val teamId: String,
    val playerId: String
)
