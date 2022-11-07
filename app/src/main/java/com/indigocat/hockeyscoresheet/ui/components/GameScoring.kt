package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Goal
import com.indigocat.hockeyscoresheet.data.api.model.Penalty
import com.indigocat.hockeyscoresheet.data.api.model.PlayType
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.ui.ColumnHeader
import com.indigocat.hockeyscoresheet.ui.extensions.getAbbreviatedType
import com.indigocat.hockeyscoresheet.ui.extensions.getNumberAndName
import com.indigocat.hockeyscoresheet.ui.extensions.timeInPeriod
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme
import com.indigocat.hockeyscoresheet.ui.theme.light_goal
import com.indigocat.hockeyscoresheet.ui.theme.light_onGoal
import com.indigocat.hockeyscoresheet.ui.theme.light_onPenalty
import com.indigocat.hockeyscoresheet.ui.theme.light_penalty

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScoringList(goals: List<Goal>) {
    var currentPeriod = rememberSaveable { 0 }
    LazyColumn {
        stickyHeader {
            ColumnHeader(stringResource(id = R.string.scoring))
        }
        items(items = goals) { goal ->
            if (goal.period != currentPeriod) {
                currentPeriod = goal.period
                PeriodHeader(period = currentPeriod)
            }
            Row(
                Modifier
                    .border(1.dp, Color.LightGray)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                GoalRow(goal)
            }
        }
    }
}

@Preview
@Composable
fun PreviewScoringList() {
    HockeyScoreSheetTheme {
        val goals = listOf(
            Goal(
                "123","456",1, 202,
                Player("1102", "Ben", "Wiener", 20),
                Player("1103", "Chase", "Saul", 7),
                null,
                Player("2101", "Good", "Goalie", 30),
                PlayType.EvenStrength
            ),
            Goal(
                "123","456",1, 825,
                Player("1124", "Jack", "Davila", 15),
                Player("1123", "Vincent", "Felt", 10),
                Player("1126", "Jackson", "Brotski", 10),
                Player("2101", "Good", "Goalie", 30),
                PlayType.EvenStrength
            ),
            Goal(
                "123","456",3, 525,
                Player("1123", "Vincent", "Felt", 10),
                Player("1126", "Jackson", "Brotski", 10),
                null,
                Player("2101", "Good", "Goalie", 30),
                PlayType.EvenStrength
            )
        )
        ScoringList(goals = goals)

    }
}

@Composable
fun PeriodHeader(period: Int) {
    Row {
        Text(stringResource(id = R.string.period, period))
    }
}

@Composable
fun GoalRow(goal: Goal) {
    AsyncImage(
        model = "https://imagedelivery.net/ErrQpIaCOWR-Tz51PhN1zA/128f7a1e-f8f1-45f3-a2ad-8d2f04230700/128",
        contentDescription = null
    )
    Text(
        goal.time.timeInPeriod(LocalContext.current),
        Modifier
            .defaultMinSize(50.dp)
            .padding(4.dp, 0.dp),
        textAlign = TextAlign.End
    )
    Text(
        goal.scorer.getNumberAndName(LocalContext.current),
        Modifier.padding(4.dp, 0.dp)
    )
    Text(
        goal.getAbbreviatedType(LocalContext.current),
        Modifier.padding(4.dp, 0.dp)
    )
//    if (goal.assist1 != null) {
//        Text(", " + goal.assist1.getNumberAndName(LocalContext.current))
//        if (goal.assist2 != null) {
//            Text(", " + goal.assist2.getNumberAndName(LocalContext.current))
//        }
//    }

}

@Preview
@Composable
fun GoalRowPreview() {
    HockeyScoreSheetTheme {
        Surface {
            val goal = Goal("123","456",
                1,
                632,
                Player("1124", "Jack", "Davila", 15),
                null,
                null,
                null,
                PlayType.EvenStrength
            )
            Column {
                GoalRow(goal)
            }
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PenaltyList(penalties: List<Penalty>) {
    var currentPeriod = rememberSaveable { 0 }
    LazyColumn {
        stickyHeader {
            ColumnHeader(stringResource(id = R.string.penalties))
        }

        items(penalties) { penalty ->
            if (penalty.period != currentPeriod) {
                currentPeriod = penalty.period
                PeriodHeader(period = currentPeriod)
            }
            PenaltyRow(penalty = penalty)
        }
    }
}

@Composable
fun PenaltyRow(penalty: Penalty) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(1.dp, Color.LightGray)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = "https://imagedelivery.net/ErrQpIaCOWR-Tz51PhN1zA/2c6825fd-aa97-404d-34d2-a01236d06000/128",
            contentDescription = null
        )
        Text(
            penalty.startTime.timeInPeriod(LocalContext.current),
            Modifier
                .defaultMinSize(50.dp)
                .padding(4.dp, 0.dp),
            textAlign = TextAlign.End
        )
        Text(
            penalty.player.getNumberAndName(LocalContext.current),
            Modifier.padding(2.dp, 0.dp)
        )
        Text(penalty.type.toString(), Modifier.padding(2.dp, 0.dp))
        Text(penalty.infraction.toString(), Modifier.padding(2.dp, 0.dp))
    }
}

