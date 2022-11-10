package com.indigocat.hockeyscoresheet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun GameSummaryScreen(
    navController: NavHostController,
    gameId: String,
    viewModel: GameViewModel,
    onClickScoreGame: (String) -> Unit = {}
) {
//    viewModel.getGameDetails(gameId)
//    val homeTeam = viewModel.homeTeam
//    val awayTeam = viewModel.awayTeam
    Column {
        Row(modifier = Modifier.padding(12.dp, 16.dp)) {
            Text("GameId $gameId")
//            TeamInfo(teamName =, iconUrl =, modifier = )
//            TeamInfo(teamName = , iconUrl = , modifier = )
        }
    }

}

@Preview
@Composable
fun GameSummaryScreenPreview() {
    Surface() {

    }
}
