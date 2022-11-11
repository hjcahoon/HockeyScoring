package com.indigocat.hockeyscoresheet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.ui.components.TeamInfo


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
    Column {
        if (game != null) {
            Row(modifier = Modifier.padding(12.dp, 16.dp)) {
                //Text("GameId $gameId")
                TeamInfo(teamName = game.homeTeam.name, iconUrl = game.homeTeam.logoUrl ?: "", Modifier.weight(1f))
                TeamInfo(teamName = game.awayTeam.name, iconUrl =  "", Modifier.weight(1f) )
            }
        } else {
            Text("Game is null, id $gameId")
        }
    }

}

@Composable
fun TeamWithScore(team: Team, finalScore: Int) {


}

//@Preview
//@Composable
//fun GameSummaryScreenPreview() {
//    Surface() {
//
//    }
//}

