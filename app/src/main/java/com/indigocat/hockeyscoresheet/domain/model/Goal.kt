package com.indigocat.hockeyscoresheet.domain.model

data class Goal(
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

enum class PointType {
    GOAL,
    ASSIST1,
    ASSIST2
}
