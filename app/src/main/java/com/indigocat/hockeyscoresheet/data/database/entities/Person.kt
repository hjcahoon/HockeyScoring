package com.indigocat.hockeyscoresheet.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val givenName: String,
    val familyName: String,
    val email: String? = null,
    val phone: String? = null
)