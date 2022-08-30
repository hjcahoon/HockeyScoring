package com.indigocat.hockeyscoresheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme

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

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            TeamInfo(
                teamName = "Resurrection Christian",
                modifier = Modifier.weight(1f),
            )
            TeamInfo(
                teamName = "Monarch Coyotes Varsity",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TeamInfo(teamName: String, modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Score(currentScore = 3)
        TeamName(text = teamName)
        ShotButton()

    }
}

@Composable
fun Score(currentScore: Int) {
    val score = remember { mutableStateOf(0)}
    Button(onClick = { score.value = score.value + 1}) {
        Text(
            text = score.value.toString(),
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

}

@Composable
fun TeamName(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun ShotButton() {
    val shotCount = remember { mutableStateOf(0)}
    Button(
        onClick = {  shotCount.value = shotCount.value + 1 }
    ) {
        Text(
            text = shotCount.value.toString(),
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HockeyScoreSheetTheme {
       App()
    }
}