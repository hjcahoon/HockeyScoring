package com.indigocat.hockeyscoresheet.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.indigocat.hockeyscoresheet.data.api.model.Game


@Composable
fun GameDayNavHost(
    navController: NavHostController,
    games: List<Game>,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = CurrentGames.route,
        modifier = modifier,
    ) {
        composable(
            route = CurrentGames.route,
            arguments = listOf(navArgument("gameId") { type = NavType.StringType  })
        ) {
            ListOfGames(
                navController,
                games = games
            )
        }

        composable(
            route = GameSummary.routeWithArgs,
            arguments = GameSummary.arguments
        ) { backStackEntry ->
            val viewModel = hiltViewModel<GameViewModel>()
            val gameId = backStackEntry.arguments?.getString(GameSummary.gameIdArg) ?: ""
            GameSummaryScreen(
                navController,
                gameId,
                viewModel,
                onClickScoreGame = { gameId ->
                    navController.navigateToGameScoring(gameId)
                }
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }


fun NavHostController.navigateToGameSummary(gameId: String) {
    this.navigateSingleTopTo("${GameSummary.route}/$gameId")
}

fun NavHostController.navigateToGameScoring(gameId: String) {
    this.navigateSingleTopTo("${ScoreGame.route}/$gameId")
}
