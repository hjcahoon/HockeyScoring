package com.indigocat.hockeyscoresheet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.domain.extensions.getNumberAndName
import com.indigocat.hockeyscoresheet.domain.model.Player
import com.indigocat.hockeyscoresheet.domain.model.PointType
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme
import timber.log.Timber


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
                val players =  listOf(
                    Player("1124", "Jack", "Davila", 15),
                    Player("1123", "Vincent", "Felt", 10),
                    Player("1126", "Jackson", "Brotski", 10),
                    Player("2101", "Good", "Goalie", 30)
                )

                AutoCompletePlayerTextView(
                    defaultPlayer = Player("1123", "Vincent", "Felt", 10),
                    suggestions = players,
                    modifier = Modifier,
                    onPlayerSelected = onPlayerSelected,
                    pointType = PointType.GOAL,
                    label = { Text(stringResource(id = R.string.goal_scorer)) }
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
        Modifier.padding(4.dp,0.dp),
        style = MaterialTheme.typography.labelMedium
    )
}

@Composable
fun Label(stringResourceId: Int) {
    Text(
        text = stringResource(id = stringResourceId),
        style = MaterialTheme.typography.labelMedium
    )
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
        val showDropdown = rememberSaveable { mutableStateOf(false) }

        OutlinedTextField(
            value = selectedPlayer.getNumberAndName(LocalContext.current),
            onValueChange = { selectedPlayer = defaultPlayer },
            modifier = Modifier.fillMaxWidth(),
            label = label,
        )
        if (showDropdown.value) {
            DropdownMenu(
                expanded = suggestions.isNotEmpty(),
                onDismissRequest = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                suggestions.forEach { player ->
                    DropdownMenuItem(
                        text = { Text(player.getNumberAndName(LocalContext.current)) },
                        onClick = {
                            onPlayerSelected(player.id, pointType)
                            selectedPlayer = player
                        }
                    )
                }
            }
        }
    }
}

val onPlayerSelected = {
    playerId: String, pointType: PointType ->
    Timber.d("Selected $playerId goalType $pointType")
}


@Composable
@Preview(showBackground = true)
fun Preview() {
    HockeyScoreSheetTheme {
        EditGoalContent()
    }
}