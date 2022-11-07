package com.indigocat.hockeyscoresheet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Facility
import com.indigocat.hockeyscoresheet.data.api.model.Game
import com.indigocat.hockeyscoresheet.data.api.model.Person
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.data.api.scoringService
import com.indigocat.hockeyscoresheet.data.database.ScoringDatabase
import com.indigocat.hockeyscoresheet.data.database.entities.Player
import com.indigocat.hockeyscoresheet.data.repository.GameRepository
import com.indigocat.hockeyscoresheet.ui.components.GameCard
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return (MainViewModel(GameRepository(
                        scoringService,
                        ScoringDatabase.getDatabase(this@MainActivity)
                    )) as T)
            }
        }
    })
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
    HockeyScoreSheetTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ListOfGames(games = currentGames)
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListOfGames(games: List<Game>?) {
    if (games == null) return
    LazyColumn {
        stickyHeader {
            ColumnHeader(stringResource(id = R.string.upcoming_games))
        }
        items(items = games) { game ->
            GameCard(game)
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
        ListOfGames(games = games)
    }
}
