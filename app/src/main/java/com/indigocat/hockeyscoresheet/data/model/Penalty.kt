package com.indigocat.hockeyscoresheet.data.model

data class Penalty(
    val id: String,
    val startTime: String,
    val endTime: String? = null,
    val player: Player,
    val servedBy: Player?,
    val penaltyLength: String,
    val length: PenaltyLength,
    val infraction: Infraction,


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

enum class PenaltyLength(seconds: Int) {
    OneMinute(60),
    OneMinute30Seconds(90),
    TwoMinutes(120),
    FiveMinutes(3000),
    TenMinutes(6000),
}

