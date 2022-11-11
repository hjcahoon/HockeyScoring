package com.indigocat.hockeyscoresheet.data.api.model

data class Team(
    val id: String,
    val name: String,
    val nickname: String? = null,
    val headCoach: Person? = null,
    val facility: String? = null,
    val logoUrl: String? = null,
    val wins: Int = 0,
    val losses: Int = 0
)
