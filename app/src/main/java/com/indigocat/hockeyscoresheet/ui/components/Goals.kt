package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Goal
import com.indigocat.hockeyscoresheet.data.api.model.Shot
import com.indigocat.hockeyscoresheet.ui.components.data.goals
import com.indigocat.hockeyscoresheet.ui.components.data.shots
import com.indigocat.hockeyscoresheet.ui.components.style.BoldText
import com.indigocat.hockeyscoresheet.ui.extensions.getAbbreviatedType
import com.indigocat.hockeyscoresheet.ui.extensions.getNumberAndName
import com.indigocat.hockeyscoresheet.ui.extensions.timeInPeriod
import com.indigocat.hockeyscoresheet.ui.games.ColumnHeader
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme

@Composable
fun GoalsByPeriodSummary(goals: List<Goal>?, homeTeamId: String) {
    val homeGoals = goals?.filter { it.teamId == homeTeamId }
    val awayGoals = goals?.filter { it.teamId != homeTeamId }
    val homeGoalsByPeriod = homeGoals?.groupBy { it.period }
    val awayGoalsByPeriod = awayGoals?.groupBy { it.period }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(
           MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        RowLabel(text ="Goal Summary", Modifier.weight(3f) )
        TableHeader(text = "1", Modifier.weight(.5f))
        TableHeader(text = "2", Modifier.weight(.5f))
        TableHeader(text = "3", Modifier.weight(.5f))
        TableHeader(text="Final", Modifier.weight(.5f))
    }
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        RowLabel(text ="Avalanche", Modifier.weight(3f) )
        TableCell(text = (homeGoalsByPeriod?.get(1)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (homeGoalsByPeriod?.get(2)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (homeGoalsByPeriod?.get(3)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text=(homeGoals?.size ?: 0).toString(), Modifier.weight(.5f))
    }
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        RowLabel(text ="Maple Leafs", Modifier.weight(3f) )
        TableCell(text = (awayGoalsByPeriod?.get(1)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (awayGoalsByPeriod?.get(2)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (awayGoalsByPeriod?.get(3)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text=(awayGoals?.size ?: 0).toString(), Modifier.weight(.5f))
    }
}

@Composable
fun RowLabel(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier.padding(4.dp, 0.dp))
}

@Composable
fun TableHeader(text: String, modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Text(text = text)
    }
}

@Composable
fun TableCell(text: String, modifier: Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        Text(text)
    }
}



@Composable
fun ShotSummaryByPeriod(shots: List<Shot>?, homeTeamId: String) {
    val homeShots = shots?.filter { it.teamId == homeTeamId }
    val awayShots = shots?.filter { it.teamId != homeTeamId }
    val homeShotsByPeriod = homeShots?.groupBy { it.periodId }
    val awayShotsByPeriod = awayShots?.groupBy { it.periodId }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(
            MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        RowLabel(text ="Shot Summary", Modifier.weight(3f) )
        TableHeader(text = "1", Modifier.weight(.5f))
        TableHeader(text = "2", Modifier.weight(.5f))
        TableHeader(text = "3", Modifier.weight(.5f))
        TableHeader(text="Total", Modifier.weight(.5f))
    }

    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        RowLabel(text ="Avalanche", Modifier.weight(3f) )
        TableCell(text = (homeShotsByPeriod?.get(1)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (homeShotsByPeriod?.get(2)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (homeShotsByPeriod?.get(3)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text=(homeShots?.size ?: 0).toString(), Modifier.weight(.5f))
    }
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        RowLabel(text ="Maple Leafs", Modifier.weight(3f) )
        TableCell(text = (awayShotsByPeriod?.get(1)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (awayShotsByPeriod?.get(2)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text = (awayShotsByPeriod?.get(3)?.size ?: 0).toString(), Modifier.weight(.5f))
        TableCell(text=(awayShots?.size ?: 0).toString(), Modifier.weight(.5f))
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GoalDetailList(goals: List<Goal>, homeTeamId: String) {
    var currentPeriod = rememberSaveable { 0 }
    var homeScore = rememberSaveable { 0 }
    var awayScore = rememberSaveable { 0 }
    LazyColumn {
        stickyHeader {
            ColumnHeader(stringResource(id = R.string.scoring))
        }
        items(items = goals) {  goal ->
            if (goal.period != currentPeriod) {
                currentPeriod = goal.period
                PeriodHeader(period = currentPeriod)
            }
            if (goal.teamId == homeTeamId) {
                homeScore += 1
            } else awayScore += 1
            GoalRow(goal, homeScore, awayScore)
        }
    }
}

@Composable
fun PeriodHeader(period: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.surfaceVariant
            )
            .padding(4.dp, 0.dp)
    ) {
        Text(stringResource(id = R.string.period, period))
    }
}

@Composable
fun GoalRow(goal: Goal, homeScore: Int, awayScore: Int, teamLogoUrl: String? = null) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            goal.time.timeInPeriod(LocalContext.current),
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

        Column(Modifier.padding(4.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Row {
                        val context = LocalContext.current
                        BoldText(
                            goal.scorer.getNumberAndName(context)
                        )
                        val type =  goal.getAbbreviatedType(context)
                        Text(
                            stringResource(id = R.string.goal_type_paren,
                               type
                            ),
                            Modifier.padding(4.dp, 0.dp)
                        )
                    }
                }
                Text(
                    stringResource(id = R.string.game_score, awayScore, homeScore),
                    Modifier.padding(4.dp, 0.dp))
            }
            Row {
                if (goal.assist1 != null) {
                    Text(goal.assist1.getNumberAndName(LocalContext.current))
                    if (goal.assist2 != null) {
                        Text(", " + goal.assist2.getNumberAndName(LocalContext.current))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewGoalsByPeriodSummary() {

    HockeyScoreSheetTheme {
        Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
            Column {
                GoalsByPeriodSummary(goals = goals, homeTeamId = "1")
            }
        }
    }
}

@Preview
@Composable
fun PreviewShotsByPeriod() {

    HockeyScoreSheetTheme {
        Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
            Column {
                ShotSummaryByPeriod(shots = shots, homeTeamId = "1")
            }
        }
    }
}

@Preview
@Composable
fun PreviewScoringList() {
    HockeyScoreSheetTheme {
        Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
            GoalDetailList(goals = goals, "1")
        }

    }
}

@Preview
@Composable
fun GoalRowPreview() {
    HockeyScoreSheetTheme {
        Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
            GoalRow(goals[0], 1, 2)
        }
    }
}





