package com.indigocat.hockeyscoresheet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.indigocat.hockeyscoresheet.ui.components.GameScore


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
    if (game != null) {
        Column {
            GameScore(game = game)
        }
    }

}


//@Preview
//@Composable
//fun GameSummaryScreenPreview() {
//    Surface() {
//
//    }
//}

