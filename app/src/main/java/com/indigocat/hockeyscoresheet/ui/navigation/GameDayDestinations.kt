package com.indigocat.hockeyscoresheet.ui.navigation

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
object GameSummaryDestination: GameDayDestinations {
    override val route = "game_summary"
    const val gameIdArg = "game_id"
    val routeWithArgs = "$route/{$gameIdArg}"
    override val arguments = listOf(
        navArgument(gameIdArg) { type = NavType.StringType }
    )
}

object ScoreGameDestination: GameDayDestinations {
    override val route = "score_game"
    const val gameIdArg = "game_id"
    val routeWithArgs = "$route/{$gameIdArg}"
    override val arguments = listOf(
        navArgument(GameSummaryDestination.gameIdArg) { type = NavType.StringType }
    )
}

object EditGoal: GameDayDestinations {
    override val route = "edit_goal/{homeId}?goalieId={goalieId}"
    override val arguments = emptyList<NamedNavArgument>()
}


