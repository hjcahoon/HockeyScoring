package com.indigocat.hockeyscoresheet.data.model

data class Tournament(
    val id: String?,
    val name: String,
    val city: String? = null,
    val state: String? = null,
    val divisions: List<Division>? = null
)
