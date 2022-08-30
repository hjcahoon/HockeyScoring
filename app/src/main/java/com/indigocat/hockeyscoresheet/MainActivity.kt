package com.indigocat.hockeyscoresheet

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        Row(modifier = Modifier.padding(24.dp)) {
            Score(currentScore = 3)
            Score(currentScore = 4)
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.headlineLarge)
}

@Composable
fun Score(currentScore: Int) {
    Text(
        text = currentScore.toString(),
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier.padding(12.dp)
            .border(
                1.dp,
                MaterialTheme.colorScheme.primary,
                RoundedCornerShape(3.dp)
            )
            .defaultMinSize(minWidth = 48.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HockeyScoreSheetTheme {
       App()
    }
}