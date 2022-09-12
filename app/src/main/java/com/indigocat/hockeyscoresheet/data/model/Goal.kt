package com.indigocat.hockeyscoresheet.data.model

data class Goal(
    val time: String,
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

enum class PointType {
    GOAL,
    ASSIST1,
    ASSIST2
}
