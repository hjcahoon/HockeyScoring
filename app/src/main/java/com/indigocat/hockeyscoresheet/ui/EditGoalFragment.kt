package com.indigocat.hockeyscoresheet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.model.Player
import com.indigocat.hockeyscoresheet.data.model.PointType
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme


class GoalEditFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                HockeyScoreSheetTheme {
                    EditGoalContent()
                }
            }
        }
    }
}

@Composable
fun EditGoalContent(viewModel: EditGoalViewModel = hiltViewModel()) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {

        Column {

            Row(
                Modifier.padding(bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.time_of_goal)
                GoalTime()
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.goal_scorer)
                AutoCompletePlayerTextView(
                    defaultPlayer = Player.defaultPlayer(),
                    suggestions = viewModel.game.value?.homeTeam?.players ?: emptyList(),
                    modifier = Modifier,
                    onPlayerSelected = viewModel::onPlayerSelected,
                    pointType = PointType.GOAL
                )
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.assist_1)
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.assist_2)
            }
        }

    }
}

@Composable
fun GoalTime() {
    Text(
        text= "12:32",
        style = MaterialTheme.typography.labelMedium,
    )
}

@Composable
fun Label(stringResourceId: Int) {
    Text(
        text = stringResource(id = stringResourceId),
        style = MaterialTheme.typography.labelMedium
    )
}

@Composable
fun PlayerName(player: Player) {
    val playerName =
        if (player.number != -1) {
            stringResource(
                R.string.player_name_and_number,
                player.number,
                player.givenName,
                player.familyName
            )
        } else {
            stringResource(
                id = R.string.player_name,
                player.givenName,
                player.familyName
            )
        }
    Text(text = playerName)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompletePlayerTextView(
    defaultPlayer: Player,
    suggestions: List<Player>,
    modifier: Modifier,
    onPlayerSelected: (String, PointType) -> Unit,
    label: @Composable (()-> Unit)? = null,
    pointType: PointType
) {
    Column(modifier = modifier) {
        var selectedPlayer = defaultPlayer
        OutlinedTextField(
            value = selectedPlayer.displayPlayer,
            onValueChange = { selectedPlayer = defaultPlayer },
            modifier = Modifier.fillMaxWidth(),
            label = label
        )
        DropdownMenu(
            expanded = suggestions.isNotEmpty(),
            onDismissRequest = {  },
            modifier = Modifier.fillMaxWidth()
        ) {
            suggestions.forEach { player ->
                DropdownMenuItem(
                    text = { PlayerName(player = player) },
                    onClick = {
                        onPlayerSelected(player.id, pointType)
                        selectedPlayer = player
                      }
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    HockeyScoreSheetTheme {
        EditGoalContent()
    }
}