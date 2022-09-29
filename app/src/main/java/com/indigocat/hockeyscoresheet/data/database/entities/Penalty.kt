package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Penalty(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val gameId: String,
    val player: String,
    val time: Int,
    val period: Int,
    val infraction: String,
    val servedBy: String? = null
)