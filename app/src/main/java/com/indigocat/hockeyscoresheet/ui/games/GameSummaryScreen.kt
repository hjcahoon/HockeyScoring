package com.indigocat.hockeyscoresheet.ui.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.indigocat.hockeyscoresheet.ui.components.GameLocation
import com.indigocat.hockeyscoresheet.ui.components.GameScore
import com.indigocat.hockeyscoresheet.ui.components.GoalsByPeriodSummary
import com.indigocat.hockeyscoresheet.ui.components.TeamNamesFullWidth
import com.indigocat.hockeyscoresheet.ui.components.style.Label3
import com.indigocat.hockeyscoresheet.ui.extensions.getPrettyDate


@Composable
fun GameSummaryScreen(
    navController: NavHostController,
    gameId: String,
    viewModel: GameViewModel,
    onClickScoreGame: (String) -> Unit = {}
) {
    viewModel.setGameId(gameId)
    val game = viewModel.gameDetails.observeAsState().value
    val homeRoster = viewModel.homeRoster.observeAsState().value
    val awayAway = viewModel.awayRoster.observeAsState().value
    val goals = viewModel.goals.observeAsState().value

    if (game != null) {
        Column {

            GameScore(game = game)
            TeamNamesFullWidth(
                homeName = game.homeTeam.name,
                awayName = game.awayTeam.name
            )
            getPrettyDate(game.startTime)?.let {
                Label3(it, Modifier.padding(16.dp))
            }
            game.facility?.let { GameLocation(it) }
            GoalsByPeriodSummary(goals, game.homeTeam.id)
        }

    }

}


//@Preview
//@Composable
//fun GameSummaryScreenPreview() {
//    HockeyScoreSheetTheme() {
//
//    }
//}

