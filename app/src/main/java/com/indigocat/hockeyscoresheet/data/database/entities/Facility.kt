package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Facility (
    @PrimaryKey
    val id: String,
    val name: String?,
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val description: String? = null
)
