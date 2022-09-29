package com.indigocat.hockeyscoresheet.domain.model

data class League(
    val id: String,
    val name: String,
    val location: String? = null
)
