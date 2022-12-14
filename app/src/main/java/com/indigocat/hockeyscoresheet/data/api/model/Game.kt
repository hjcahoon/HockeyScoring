package com.indigocat.hockeyscoresheet.data.api.model

data class Game(
    val id: String,
    //val division: Division?,
    val homeTeam: Team,
    val awayTeam: Team,
    val facility: Facility?,
    val rink: String?,
    val startTime: String,
    val homeScore: Int? = null,
    val awayScore: Int? = null
)
