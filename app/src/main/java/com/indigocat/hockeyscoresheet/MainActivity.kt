package com.indigocat.hockeyscoresheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indigocat.hockeyscoresheet.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HockeyScoreSheetTheme {
                App()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Row(modifier = Modifier.padding(12.dp, 16.dp)) {
                TeamInfo(
                    teamName = "Resurrection Christian",
                    modifier = Modifier.weight(1f),
                )
                TeamInfo(
                    teamName = "Monarch Coyotes Varsity",
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.padding(12.dp)) {
                PenaltyButton(modifier = Modifier.weight(0.5f))
                GoalButton(modifier = Modifier.weight(0.5f))
            }

            Row(modifier = Modifier.padding(12.dp, 12.dp)) {
                LazyColumn {
                    stickyHeader {
                        ColumnHeader(stringResource(id = R.string.scoring))
                    }
                }
            }
            Row(modifier = Modifier.padding(12.dp, 12.dp)) {
                LazyColumn {
                    stickyHeader {
                        ColumnHeader(stringResource(id = R.string.penalties))
                    }
                }
            }
        }
    }
}

@Composable
fun TeamInfo(teamName: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Score(currentScore = 3)
        TeamName(text = teamName)
        ShotButton()
    }
}

@Composable
fun Score(currentScore: Int) {
    Text(
        text = currentScore.toString(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primaryContainer,
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .defaultMinSize(minWidth = 60.dp)
            .background(
                MaterialTheme.colorScheme.onPrimaryContainer,
                RoundedCornerShape(3.dp)
            )
    )
}

@Composable
fun TeamName(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(8.dp)
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ShotButton() {
    val shotCount = rememberSaveable { mutableStateOf(0) }
    Button(
        onClick = { shotCount.value = shotCount.value + 1 },
        modifier = Modifier.defaultMinSize(120.dp, 48.dp)
    ) {
        Text(
            text = pluralStringResource(R.plurals.shot_count, shotCount.value, shotCount.value),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GoalButton(modifier: Modifier) {
    Button(
        modifier = modifier
            .padding(8.dp)
            .defaultMinSize(minHeight = 48.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            light_goal,
            light_onGoal
        )
    ) {
        Text(
            text = stringResource(id = R.string.goal),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PenaltyButton(modifier: Modifier) {
    Button(
        modifier = modifier
            .padding(8.dp)
            .defaultMinSize(minHeight = 48.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            light_penalty,
            light_onPenalty
        )

    ) {
        Text(
            text = stringResource(id = R.string.penalty),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
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
fun DefaultPreview() {
    HockeyScoreSheetTheme {
        App()
    }
}