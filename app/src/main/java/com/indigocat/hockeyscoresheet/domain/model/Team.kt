package com.indigocat.hockeyscoresheet.domain.model

data class Team(
    val it: String,
    val name: String,
    val nickname: String?,
    val headCoach: Person?,
    val assistantCoaches: List<Person>?,
    val players: List<Player>?,
    val games: List<Game>
){
}