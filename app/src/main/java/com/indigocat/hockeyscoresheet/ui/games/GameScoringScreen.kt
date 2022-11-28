package com.indigocat.hockeyscoresheet.ui.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.indigocat.hockeyscoresheet.data.api.model.Infraction
import com.indigocat.hockeyscoresheet.data.api.model.Penalty
import com.indigocat.hockeyscoresheet.data.api.model.PenaltyType
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.ui.components.GoalButton
import com.indigocat.hockeyscoresheet.ui.components.GoalDetailList
import com.indigocat.hockeyscoresheet.ui.components.PenaltyButton
import com.indigocat.hockeyscoresheet.ui.components.PenaltyList
import com.indigocat.hockeyscoresheet.ui.components.TeamInfo
import com.indigocat.hockeyscoresheet.ui.components.data.avalanche
import com.indigocat.hockeyscoresheet.ui.components.data.goals
import com.indigocat.hockeyscoresheet.ui.components.data.mapleLeafs
import com.indigocat.hockeyscoresheet.ui.components.data.penalties
import com.indigocat.hockeyscoresheet.ui.theme.GameDayTheme

@Composable
fun ScoreGameScreen(
    navHostController: NavHostController,
    gameId: String
) {

    val viewModel = hiltViewModel<GameViewModel>()
    viewModel.setGameId(gameId)
    val gameDetails = viewModel.gameDetails.observeAsState().value
    val goals = viewModel.goals.observeAsState().value
    val showTeamChooser = rememberSaveable { false }

    if (gameDetails != null) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            val showTeamChooser = rememberSaveable { false }
            Column {
                TeamsWithScore(
                    homeTeam = gameDetails.homeTeam,
                    awayTeam = gameDetails.awayTeam
                )
                Row(modifier = Modifier.padding(12.dp)) {
                    PenaltyButton(modifier = Modifier.weight(0.5f))
                    GoalButton(modifier = Modifier.weight(0.5f))
                }

                Row(modifier = Modifier.padding(12.dp, 12.dp)) {
                    GoalDetailList(goals ?: emptyList(), "1")
                }
                Row(modifier = Modifier.padding(12.dp, 12.dp)) {

                    val penalties = listOf(
                        Penalty(
                            "102", "103", 1, 400,
                            Player("502", "Sam", "Adams", 5),
                            PenaltyType.Minor,
                            Infraction.Tripping
                        )
                    )
                    PenaltyList(penalties = penalties)
                }
            }
        }
    }
}

fun showTeamChooserDialog() {

}

@Composable
fun TeamsWithScore(
    homeTeam: Team,
    awayTeam: Team,
) {
    Row(modifier = Modifier.padding(12.dp, 16.dp)) {
        TeamInfo(
            teamName = awayTeam.name,
            iconUrl = awayTeam.logoUrl ?: "",
            Modifier.weight(1f)
        )
        TeamInfo(
            teamName = homeTeam.name,
            iconUrl = homeTeam.logoUrl ?: "",
            Modifier.weight(1f)
        )
    }
}


@Composable
fun ColumnHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewScoreGame() {
    GameDayTheme {
        Column {
            TeamsWithScore(
                homeTeam = avalanche,
                awayTeam = mapleLeafs
            )
            Row(modifier = Modifier.padding(12.dp)) {
                PenaltyButton(modifier = Modifier.weight(0.5f))
                GoalButton(modifier = Modifier.weight(0.5f))
            }

            Row(modifier = Modifier.padding(12.dp, 12.dp)) {
                GoalDetailList(goals ?: emptyList(), "1")
            }
            Row(modifier = Modifier.padding(12.dp, 12.dp)) {
                PenaltyList(penalties = penalties)
            }

        }
    }
}

@Preview
@Composable
fun PreviewTeamsWithScore() {

    GameDayTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TeamsWithScore(homeTeam = avalanche, awayTeam = mapleLeafs)
        }
    }
}

