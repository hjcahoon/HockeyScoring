package com.indigocat.hockeyscoresheet.domain.model

data class Game(
    val id: String,
    val division: Division?,
    val homeTeam: Team,
    val awayTeam: Team,
    val facility: Facility?,
    val rink: String?,
    val startTime: String,
    val goals: List<Goal>?,
    val penalties: List<Penalty>
)
