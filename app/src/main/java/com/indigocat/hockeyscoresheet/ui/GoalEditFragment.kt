package com.indigocat.hockeyscoresheet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.model.Player
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
fun EditGoalContent() {
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
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
                PlayerPoint()
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.assist_1)
                PlayerPoint()
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.assist_2)
                PlayerPoint()
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
fun PlayerPoint() {
    Button(
        onClick = {  },
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        
    }
}

@Composable
fun PlayerSelector(list: List<Player>) {
    val expanded = remember { mutableStateOf(false) }
    val selectedPlayer = rememberSaveable {
        mutableStateOf(Player.defaultPlayer())
    }
    DropdownMenu(
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }
    ) {
        list.forEach { player ->
            DropdownMenuItem(
                text = { PlayerName(player = player) },
                onClick = { selectedPlayer.value = player }
            )
        }
    }

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


@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    HockeyScoreSheetTheme {
        EditGoalContent()
    }
}