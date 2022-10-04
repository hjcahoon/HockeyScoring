package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AssistantCoachTeam(
    @PrimaryKey
    val id: String,
    val teamId: Int,
    val personId: Int
)
