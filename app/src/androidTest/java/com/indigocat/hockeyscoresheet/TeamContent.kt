package com.indigocat.hockeyscoresheet

import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Team

object TeamContent {

    val monarchGold = Team(
        "1",
        "Monarch Gold",
        "Coyotes",
        headCoach = MonarchContent.headCoach,
        assistantCoaches = MonarchContent.assistantCoaches,
        players = MonarchContent.players,
        games = emptyList<Game>()
    )

    val avalanche = Team(
        "2",
        "Colorado Avalanche",
        "Avs",
        Avalanche.headCoach,
        Avalanche.assistantCoaches,
        Avalanche.players,
        emptyList()
    )

    val game1 = Game(
        "1",
        homeTeam = monarchGold,
        awayTeam = avalanche,
        facility = MonarchContent.sportStable,
        startTime = "2022-10-01T19:30:00+6:00",
        rink = "West"

    )
}
