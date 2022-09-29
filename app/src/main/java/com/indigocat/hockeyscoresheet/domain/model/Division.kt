package com.indigocat.hockeyscoresheet.domain.model

data class Division(
    val id: String,
    val name: String,
    val league: League?,
    val tournament: Tournament?,
    val ageGroup: String? = null,
    val level: String? = null,
    val games: List<Game>? = null
)
