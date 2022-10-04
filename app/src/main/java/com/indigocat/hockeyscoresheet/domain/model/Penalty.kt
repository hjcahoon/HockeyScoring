package com.indigocat.hockeyscoresheet.domain.model

data class Penalty(
    val id: String,
    val period: Int,
    val startTime: Int,
    val player: Player,
    val type: PenaltyType,
    val infraction: Infraction,
    val servedBy: Player? = null,
    val endTime: String? = null,
)

enum class Infraction {
    AbuseOfOfficials,
    AttemptToInjure,
    RecklesslyEndanger,
    Boarding,
    BodyChecking,
    Charging,
    CheckingFromBehind,
    CrossChecking,
    DelayingTheGame,
    Elbowing,
    Fighting,
    HeadButting,
    HeadContact,
    HighSticking,
    Holding,
    Hooking,
    Interference,
    KickingOpponent,
    KickingPuck,
    Kneeing,
    RefusingToStartPlay,
    Roughing,
    Slashing,
    Spearing,
    ThrowingStickOrObject,
    Tripping
}

enum class PenaltyType {
    Minor,
    Major,
    Misconduct,
    Match,
    PenaltyShot
}

@Suppress("MagicNumber")
enum class PenaltyLength(seconds: Int) {
    OneMinute(60),
    OneMinute30Seconds(90),
    TwoMinutes(120),
    FiveMinutes(3000),
    TenMinutes(6000)
}

