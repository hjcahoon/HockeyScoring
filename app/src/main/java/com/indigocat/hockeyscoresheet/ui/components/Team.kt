package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun TeamInfo(
    teamName: String,
    iconUrl: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier.matchParentSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(iconUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alpha = 0.2f
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Score(currentScore = 3)
            TeamName(text = teamName)
            ShotButton()
        }
    }
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
