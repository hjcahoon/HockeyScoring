package com.indigocat.hockeyscoresheet.ui.games.scoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.ui.extensions.getNumberAndName
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme
import timber.log.Timber
import java.util.*


class EditGoalFragment : Fragment() {

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
    Surface(
        modifier = Modifier
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
                val players = listOf(
                    Player("1124", "Jack", "Davila", 15),
                    Player("1123", "Vincent", "Felt", 10),
                    Player("1126", "Jackson", "Brotski", 10),
                    Player("2101", "Good", "Goalie", 30)
                )

                AutoCompletePlayerTextView(
                    suggestions = players,
                    modifier = Modifier,
                    onPlayerSelected = onPlayerSelected,
                    label = { Text(stringResource(id = R.string.goal_scorer)) }
                )
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.assist_1)
                PlayerSelection()
            }
            Row(
                Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(stringResourceId = R.string.assist_2)
                PlayerSelection()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalTime() {
    val timeText = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = formatTime(timeText.value),
        onValueChange = { timeText.value = it.replace(":", "".replace("0","")) },
        modifier = Modifier.padding(4.dp, 0.dp),
        textStyle = MaterialTheme.typography.labelMedium,
        keyboardOptions = KeyboardOptions(
            KeyboardCapitalization.None,
            true,
            KeyboardType.Number
        )
    )
}

fun formatTime(text: String) : String {
    val begin = text.replace(":", "").replace("0", "")
    var asTime = ""
    when(begin.length) {
        0 -> { println("Should not be here")}
        1 -> asTime = "0:0$begin"
        2 -> asTime = "0:$begin"
        3,4 -> asTime = begin.replaceRange(begin.length - 2, begin.length - 2, ":")
    }
    Timber.d("start $text end $asTime")
    return asTime

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
    suggestions: List<Player>,
    modifier: Modifier,
    onPlayerSelected: (String) -> Unit,
    label: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        val selectedPlayerIndex = rememberSaveable { mutableStateOf(0) }
        val showDropdown = rememberSaveable { mutableStateOf(false) }

        OutlinedTextField(
            value = suggestions[selectedPlayerIndex.value].getNumberAndName(LocalContext.current),
            onValueChange = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
                .clickable {
                    showDropdown.value = !showDropdown.value
                },
            label = label,
            keyboardOptions = KeyboardOptions(
                KeyboardCapitalization.None,
                true,
                KeyboardType.Number
            )
        )
        if (showDropdown.value) {
            DropdownMenu(
                expanded = showDropdown.value,
                onDismissRequest = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                for ((index, player) in suggestions.withIndex()) {
                    DropdownMenuItem(
                        text = { Text(suggestions[index].getNumberAndName(LocalContext.current)) },
                        onClick = {
                            onPlayerSelected(player.id)
                            showDropdown.value = false
                            selectedPlayerIndex.value = index
                        }
                    )
                }
            }
        }
    }
}

val onPlayerSelected = { playerId: String  ->
    Timber.d("Selected $playerId")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerSelection() {
    val players = listOf(
        Player("1124", "Jack", "Davila", 15),
        Player("1123", "Vincent", "Felt", 10),
        Player("1126", "Jackson", "Brotski", 10),
        Player("2101", "Good", "Goalie", 30)
    )
    var expanded = remember { mutableStateOf(false) }
    var selectedPlayerNumber = remember { mutableStateOf(players[0].number) }
    var typedValue = remember { mutableStateOf("false") }

    ExposedDropdownMenuBox(
        expanded = expanded.value,
        onExpandedChange = {
            expanded.value = !expanded.value
        }
    ) {
        OutlinedTextField(
            value = players.filter { it.number == selectedPlayerNumber.value
                }[0].getNumberAndName(LocalContext.current),
            onValueChange = { typedValue.value = it },
            modifier = Modifier
                .menuAnchor()
                .padding(4.dp, 0.dp),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value) },
            label = { Text("Assist") },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            keyboardOptions = KeyboardOptions(
                KeyboardCapitalization.None,
                true,
                KeyboardType.Number
            )
        )
        var filteredPlayers = players.filter {
            it.number.toString().startsWith(typedValue.value)
        }
        if (filteredPlayers.isEmpty()) {
            filteredPlayers = players
        }

        ExposedDropdownMenu(
            expanded = expanded.value,
            onDismissRequest = {
                expanded.value = false
            }
        ) {
            filteredPlayers.forEach { player ->
                DropdownMenuItem(
                    text = { Text(text = player.getNumberAndName(LocalContext.current)) },
                    onClick = {
                        selectedPlayerNumber.value = player.number
                        expanded.value = false
                    }
                )
            }
        }

    }
    fun filterResults(input: String, players: List<Player>) {
        try {
            Integer.parseInt(input)
            players.filter { it.number.toString().startsWith(input) }
        } catch (e: java.lang.NumberFormatException) {
            // else its a string
            players.filter { it.familyName.startsWith(input) || it.givenName.startsWith(input) }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun EditGoalPreview() {
    HockeyScoreSheetTheme {
        EditGoalContent()
    }
}
