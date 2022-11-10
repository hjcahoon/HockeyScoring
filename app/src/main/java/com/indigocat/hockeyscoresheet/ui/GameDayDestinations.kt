package com.indigocat.hockeyscoresheet.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface GameDayDestinations {
    val route: String
    val arguments: List<NamedNavArgument>
}

object CurrentGames: GameDayDestinations {
    override val route = "current_games"
    override val arguments = emptyList<NamedNavArgument>()

}
object GameSummary: GameDayDestinations {
    override val route = "game_summary"
    const val gameIdArg = "game_id"
    val routeWithArgs = "$route/{$gameIdArg}"
    override val arguments = listOf(
        navArgument(gameIdArg) { type = NavType.StringType }
    )
}

object ScoreGame: GameDayDestinations {
    override val route = "score_game"
    override val arguments = emptyList<NamedNavArgument>()
}

object EditGoal: GameDayDestinations {
    override val route = "edit_goal/{homeId}?goalieId={goalieId}"
    override val arguments = emptyList<NamedNavArgument>()
}
