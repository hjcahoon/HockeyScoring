package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey
    val id: String,
    val name: String,
    val nickname: String?,
    val headCoach: String? = null,
    val facility: String? = null
)