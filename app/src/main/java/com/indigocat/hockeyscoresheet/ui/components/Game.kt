package com.indigocat.hockeyscoresheet.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
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
    Row(
        Modifier.padding(8.dp, 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier.size(40.dp, 40.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(team.logoUrl)
                .decoderFactory(SvgDecoder.Factory())
                .crossfade(true)
                .build(),
            contentDescription = LocalContext.current.getString(
                R.string.team_logo_content_description,
                team.name
            ),
            placeholder = painterResource(id = R.drawable.ic_hockey)
        )
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
        GameCard(
            Game(
                "123",
                Team(
                    "3",
                    "Calgary Flames",
                    "Flames",
                    Person("1", "Darryl", "Sutter"),
                    "The Saddledome"
                ),
                Team(
                    "1",
                    "Colorado Avalanche",
                    "Avalanche",
                    Person("1", "Jared", "Bednar"),
                    "Ball Arena"
                ),
                Facility("123", "The Saddledome", "", "", "", ""),
                null, "2022-11-14:7:30Z+4"
            )
        )

    }
}

@Composable
fun GameScore(game: Game) {

    val homeTeam = game.homeTeam
    val awayTeam = game.awayTeam

    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center

    ) {
        val context = LocalContext.current
        Box(modifier = Modifier.size(40.dp, 40.dp)) {
            AsyncImage(
                modifier = Modifier.matchParentSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(awayTeam.logoUrl)
                    .decoderFactory(SvgDecoder.Factory())
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(id = R.drawable.ic_hockey),
                contentDescription = context.getString(
                    R.string.team_logo_content_description,
                    awayTeam.name
                )
            )
        }

       // Text(game.awayTeam.name, Modifier.align(Alignment.CenterVertically))
        Text(
            (game.awayScore ?: " ").toString(),
            Modifier.align(Alignment.CenterVertically).padding(10.dp, 0.dp)
        )
        Text("-", Modifier.align(Alignment.CenterVertically).padding(10.dp, 0.dp))
        Text(
            (game.homeScore ?: " ").toString(),
            Modifier.align(Alignment.CenterVertically).padding(10.dp, 0.dp)
        )
       // Text(game.homeTeam.name, Modifier.align(Alignment.CenterVertically))
        AsyncImage(
            modifier = Modifier.size(40.dp, 40.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data(homeTeam.logoUrl)
                .decoderFactory(SvgDecoder.Factory())
                .crossfade(true)
                .build(),
            contentDescription = context.getString(
                R.string.team_logo_content_description,
                homeTeam.name
            ),
            placeholder = painterResource(id = R.drawable.ic_hockey)
        )

    }

}

@Preview
@Composable
fun PreviewGameScore() {
    val game = Game(
        "123",
        Team("3", "Calgary Flames", "Flames", Person("1", "Bryan", "Sutter"), "The Saddledome"),
        Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
        Facility("123", "The Saddledome", "", "", "", ""),
        null, "2022-11-14:7:30Z+4", 3, 6
    )
    HockeyScoreSheetTheme {
        GameScore(game = game)
    }
}

