package com.indigocat.hockeyscoresheet.data.api.model

data class Team(
    val it: String,
    val name: String,
    val nickname: String? = null,
    val headCoach: Person? = null,
    val facility: String? = null,
    val wins: Int = 0,
    val losses: Int = 0
)
