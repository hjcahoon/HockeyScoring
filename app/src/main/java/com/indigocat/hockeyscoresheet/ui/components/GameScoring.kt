package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Penalty
import com.indigocat.hockeyscoresheet.ui.extensions.getNumberAndName
import com.indigocat.hockeyscoresheet.ui.extensions.timeInPeriod
import com.indigocat.hockeyscoresheet.ui.games.ColumnHeader
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
            PenaltyRow(penalty = penalty, "")
        }
    }
}

@Composable
fun PenaltyRow(penalty: Penalty, teamLogoUrl: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(1.dp, Color.LightGray)
            .fillMaxWidth()
    ) {

        Text(
            penalty.startTime.timeInPeriod(LocalContext.current),
            Modifier
                .defaultMinSize(50.dp)
                .padding(4.dp, 0.dp),
            textAlign = TextAlign.End
        )
        AsyncImage(
            modifier = Modifier.size(28.dp, 28.dp),
            model = teamLogoUrl,
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_hockey),
            fallback =  painterResource(R.drawable.ic_hockey)
        )
        Text(
            penalty.player.getNumberAndName(LocalContext.current),
            Modifier.padding(2.dp, 0.dp)
        )
        Text(penalty.type.toString(), Modifier.padding(2.dp, 0.dp))
        Text(penalty.infraction.toString(), Modifier.padding(2.dp, 0.dp))
    }
}

@Preview
@Composable
fun PreviewPenaltyList() {

}

