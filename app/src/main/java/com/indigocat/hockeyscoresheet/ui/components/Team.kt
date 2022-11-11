package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme


@Composable
fun TeamInfo(
    teamName: String,
    iconUrl: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier
    ) {
        val context = LocalContext.current
        AsyncImage(
            modifier = Modifier.matchParentSize(),
            model = ImageRequest.Builder(context)
                .data(iconUrl)
                .build(),
            contentDescription = context.getString(R.string.team_logo_content_description, teamName),
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

@Preview
@Composable
fun PreviewTeamInfo() {
    HockeyScoreSheetTheme {
      Row {
          TeamInfo(
              teamName = "Monarch Coyotes Varsity",
              iconUrl = "https://imagedelivery.net/ErrQpIaCOWR-Tz51PhN1zA/128f7a1e-f8f1-45f3-a2ad-8d2f04230700/128",
              Modifier.weight(1f)
          )
      }
    }
}

