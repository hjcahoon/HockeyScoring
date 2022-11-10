package com.indigocat.hockeyscoresheet.ui.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.ui.extensions.getPrettyDate
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme


@ExperimentalMaterial3Api
@Composable
fun GameCard(
    game: Game,
    onClickScoreGame: (String) -> Unit = {}
) {
    Card(
        onClick = { onClickScoreGame(game.id) },
        modifier = Modifier.padding(0.dp, 4.dp),
        shape = RoundedCornerShape(2.dp)
    ) {
        Column(Modifier.padding(0.dp, 8.dp)) {
            GameHeader(game)
            TeamGameTitle(team = game.awayTeam, game.awayScore)
            TeamGameTitle(team = game.homeTeam, score = game.homeScore)
        }
    }

}

@Composable
fun GameHeader(game: Game) {
    Row(Modifier.padding(8.dp, 4.dp)) {
        Text(getPrettyDate(game.startTime) ?: "")
        Spacer(modifier = Modifier.weight(1f))
        Text(game.facility?.name ?: "")
    }
}

@Composable
fun TeamGameTitle(team: Team, score: Int?) {
    Row(Modifier.padding(8.dp, 4.dp)) {
        Text(
            team.name,
            Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        if (score != null) {
            Text(score.toString())
        } else {
            Text(LocalContext.current.getString(R.string.team_record, team.wins, team.losses))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewGameCard() {
    HockeyScoreSheetTheme {
        GameCard(Game(
            "123",
            Team("3", "Calgary Flames", "Flames", Person("1", "Darryl", "Sutter"), "The Saddledome"),
            Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
            Facility("123", "The Saddledome", "", "", "", ""),
            null, "2022-11-14:7:30Z+4"
        ))

    }
}
