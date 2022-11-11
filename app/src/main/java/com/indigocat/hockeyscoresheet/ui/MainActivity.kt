package com.indigocat.hockeyscoresheet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.ui.components.GameCard
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme
import com.indigocat.hockeyscoresheet.ui.theme.light_surface
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HockeyScoreSheetTheme {
                Main(viewModel)
            }
        }

    }
}

@Composable
fun Main(
    viewModel: MainViewModel
) {
    val currentGames = viewModel.currentGames.observeAsState().value
    val navController = rememberNavController()
    if (currentGames != null) {
        HockeyScoreSheetTheme {
            Surface(
                color = MaterialTheme.colorScheme.background
            ) {
                GameDayNavHost(navController = navController, currentGames, modifier = Modifier)
            }
        }
    }

}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ListOfGames(
    navController: NavHostController,
    games: List<Game>
) {

    LazyColumn {
        stickyHeader {
            Text(
                stringResource(id = R.string.upcoming_games),
                Modifier
                    .background(light_surface, RectangleShape)
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(8.dp, 4.dp)
            )
        }
        items(items = games) { game ->
            GameCard(
                game,
                onClickScoreGame = { gameId ->
                    navController.navigateToGameSummary(gameId)
                }
            )
        }
    }
}

@Composable
fun ListOfPlayer(players: List<Player>) {

    LazyColumn {
      items(items = players) { player ->
            Row() {
                Text(text = "${player.number} ${player.givenName} ${player.familyName} ${player.position}")
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun MainPreview() {

    val games = listOf(
        Game(
            "123",
            Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
            Team("2", "Toronto Maple Leafs", "Maple Leafs", Person("1", "Sheldon", "Keefe"), "Scotiabank Arena"),
            Facility("123", "Ball Arena", "", "", "", ""),
            null, "2022-11-14:7:30Z+4"
        ),
        Game(
            "123",
            Team("3", "Calgary Flames", "Flames", Person("1", "Bryan", "Sutter"), "The Saddledome"),
            Team("1", "Colorado Avalanche", "Avalanche", Person("1", "Jared", "Bednar"), "Ball Arena"),
            Facility("123", "The Saddledome", "", "", "", ""),
            null, "2022-11-14:7:30Z+4", 3, 6
        )
    )
    HockeyScoreSheetTheme {
        val navController = rememberNavController()
        ListOfGames(games = games, navController = navController )
    }
}
