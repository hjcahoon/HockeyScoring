package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Goal(
    @PrimaryKey
    val id: String,
    val goalScorer: String,
    val assist1: String? = null,
    val assist2: String? = null,
    val time: Int,
    val period: Int,
    val gameId: String,
    val apposingGoalie: String? = null
)
