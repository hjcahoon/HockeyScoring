package com.indigocat.hockeyscoresheet.data.api.model

data class Shot (
    val id: String,
    val gameId: String,
    val teamId: String,
    val periodId: Int,
    val playerId: String? = null,
    val time: Int? = null
)
