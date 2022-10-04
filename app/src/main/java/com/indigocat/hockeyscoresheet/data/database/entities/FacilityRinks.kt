package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FacilityRinks(
    @PrimaryKey
    val id: String,
    val facilityId: String,
    val rink: String
)
