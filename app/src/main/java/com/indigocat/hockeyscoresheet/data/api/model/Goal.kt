package com.indigocat.hockeyscoresheet.data.api.model

data class Goal(
    val id: String,
    val gameId: String,
    val teamId: String,
    val period: Int,
    val time: Int,
    val scorer: Player,
    val assist1: Player?,
    val assist2: Player?,
    val opposingGoalie: Player?,
    val goalType: PlayType?
)

enum class PlayType {
    EvenStrength,
    PowerPlay,
    FiveOnThree,
    ShortHanded,
    EmptyNet
}

