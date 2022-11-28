package com.indigocat.hockeyscoresheet.ui.games

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Goal
import com.indigocat.hockeyscoresheet.ui.components.GameLocation
import com.indigocat.hockeyscoresheet.ui.components.GameScore
import com.indigocat.hockeyscoresheet.ui.components.GoalDetailList
import com.indigocat.hockeyscoresheet.ui.components.GoalsByPeriodSummary
import com.indigocat.hockeyscoresheet.ui.components.ShotSummaryByPeriod
import com.indigocat.hockeyscoresheet.ui.components.TeamNamesFullWidth
import com.indigocat.hockeyscoresheet.ui.components.data.games
import com.indigocat.hockeyscoresheet.ui.components.data.goals
import com.indigocat.hockeyscoresheet.ui.components.data.shots
import com.indigocat.hockeyscoresheet.ui.components.style.Label3
import com.indigocat.hockeyscoresheet.ui.extensions.getPrettyDate
import com.indigocat.hockeyscoresheet.ui.navigation.navigateToGameScoring
import com.indigocat.hockeyscoresheet.ui.theme.GameDayTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameSummaryScreen(
    navController: NavHostController,
    gameId: String,
    viewModel: GameViewModel
) {
    viewModel.setGameId(gameId)
    val game = viewModel.gameDetails.observeAsState().value
    val goals = viewModel.goals.observeAsState().value

    val onClickScoreGame = { gameId: String ->
        navController.navigateToGameScoring(gameId)
    }
    Scaffold(
        floatingActionButton = {
            ScoreGameButton(
                onClick = onClickScoreGame
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) { contentPadding ->
        SummaryContent(
            game,
            goals,
            Modifier.padding(bottom = contentPadding.calculateBottomPadding())
        )

    }
}

@Composable
fun SummaryContent(game: Game?, goals: List<Goal>?, modifier: Modifier) {
    if (game != null) {
        GameDayTheme {
            Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
                Column {
                    GameScore(game = game)
                    TeamNamesFullWidth(
                        homeName = game.homeTeam.name,
                        awayName = game.awayTeam.name
                    )
                    getPrettyDate(game.startTime)?.let {
                        Label3(it, Modifier.padding(16.dp))
                    }
                    game.facility?.let {
                        GameLocation(
                            it,
                            Modifier.padding(0.dp, 8.dp)
                        )
                    }

                    GoalsByPeriodSummary(
                        goals, game.homeTeam.id,
                        Modifier.padding(0.dp, 8.dp)
                    )
                    ShotSummaryByPeriod(shots = shots, homeTeamId = game.homeTeam.id, Modifier.padding(0.dp, 8.dp))
                    if (goals != null) {
                        GoalDetailList(goals = goals, homeTeamId = game.homeTeam.id)
                    }

                }
            }
        }
    }
}

@Composable
fun ScoreGameButton(onClick: (String) -> Unit, modifier: Modifier = Modifier) {

    FloatingActionButton(
        onClick = { onClick },
        shape = RoundedCornerShape(32.dp),
        contentColor = MaterialTheme.colorScheme.error,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_goal_light),
            contentDescription = stringResource(id = R.string.score_game_button_cd),
            modifier = Modifier.size(48.dp, 48.dp)
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewGameSummaryScreen() {
    val game = games[2]
    GameDayTheme {
        Scaffold(
            floatingActionButton = {
                ScoreGameButton(
                    onClick = {}
                )

            }
        ) { contentPadding ->
            SummaryContent(game, goals, Modifier.padding(bottom = contentPadding.calculateBottomPadding()))

        }
    }
}

