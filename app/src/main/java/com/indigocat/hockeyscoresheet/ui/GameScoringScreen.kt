package com.indigocat.hockeyscoresheet.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indigocat.hockeyscoresheet.data.api.model.Goal
import com.indigocat.hockeyscoresheet.data.api.model.Infraction
import com.indigocat.hockeyscoresheet.data.api.model.Penalty
import com.indigocat.hockeyscoresheet.data.api.model.PenaltyType
import com.indigocat.hockeyscoresheet.data.api.model.PlayType
import com.indigocat.hockeyscoresheet.data.api.model.Player
import com.indigocat.hockeyscoresheet.ui.components.GoalButton
import com.indigocat.hockeyscoresheet.ui.components.PenaltyButton
import com.indigocat.hockeyscoresheet.ui.components.PenaltyList
import com.indigocat.hockeyscoresheet.ui.components.ScoringList
import com.indigocat.hockeyscoresheet.ui.components.TeamInfo
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme

@Composable
fun ScoreGameScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column{
            Row(modifier = Modifier.padding(12.dp, 16.dp)) {
                TeamInfo(
                    teamName = "Resurrection Christian",
                    iconUrl = "https://imagedelivery.net/ErrQpIaCOWR-Tz51PhN1zA/2c6825fd-aa97-404d-34d2-a01236d06000/128",
                    Modifier.weight(1f)
                )
                TeamInfo(
                    teamName = "Monarch Coyotes Varsity",
                    iconUrl = "https://imagedelivery.net/ErrQpIaCOWR-Tz51PhN1zA/128f7a1e-f8f1-45f3-a2ad-8d2f04230700/128",
                    Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.padding(12.dp)) {
                PenaltyButton(modifier = Modifier.weight(0.5f))
                GoalButton(modifier = Modifier.weight(0.5f))
            }

            Row(modifier = Modifier.padding(12.dp, 12.dp)) {
                val goals = listOf(
                    Goal(
                         "234", "123",1, 202,
                        Player("1102", "Ben", "Wiener", 20),
                        Player("1103", "Chase", "Saul", 7),
                        null,
                        Player("2101", "Good", "Goalie", 30),
                        PlayType.EvenStrength
                    ),
                    Goal(
                        "234", "123",1, 825,
                        Player("1124", "Jack", "Davila", 15),
                        Player("1123", "Vincent", "Felt", 10),
                        Player("1126", "Jackson", "Brotski", 10),
                        Player("2101", "Good", "Goalie", 30),
                        PlayType.EvenStrength
                    ),
                    Goal(
                        "234", "123",3, 525,
                        Player("1123", "Vincent", "Felt", 10),
                        Player("1126", "Jackson", "Brotski", 10),
                        null,
                        Player("2101", "Good", "Goalie", 30),
                        PlayType.EvenStrength
                    )
                )
                ScoringList(goals)

            }
            Row(modifier = Modifier.padding(12.dp, 12.dp)) {

                val penalties = listOf(
                    Penalty(
                        "102", "103", 1, 400,
                        Player("502", "Sam", "Adams", 5),
                        PenaltyType.Minor,
                        Infraction.Tripping
                    )
                )
                PenaltyList(penalties = penalties)
            }

        }
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
fun ScoreGamePreview() {
    HockeyScoreSheetTheme {
        ScoreGameScreen()
    }
}

