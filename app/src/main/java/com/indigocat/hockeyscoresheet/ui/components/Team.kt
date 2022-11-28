package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.ui.components.data.avalanche
import com.indigocat.hockeyscoresheet.ui.components.style.Label3
import com.indigocat.hockeyscoresheet.ui.theme.GameDayTheme


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

@Composable
fun TeamNamesFullWidth(homeName: String, awayName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Label3(text = awayName, Modifier.padding(8.dp, 0.dp), TextAlign.Center)
        Label3(text = homeName, Modifier.padding(8.dp, 0.dp), TextAlign.Center)
    }
}

@Composable
fun TeamButton(
    team: Team,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.padding(8.dp),
        onClick = { onClick(team.id) },
        shape = RoundedCornerShape(16.dp)
    ) {
        TeamImageWithName(team)
    }
}
@Composable
fun TeamImageWithName(team: Team) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = team.logoUrl,
            modifier = Modifier.size(40.dp, 40.dp),
            contentDescription = stringResource(id = R.string.team_logo_content_description, team.name),
            placeholder = painterResource(R.drawable.ic_hockey),
            fallback = painterResource(id = R.drawable.ic_hockey)
        )
        Text(
            text = team.name,
            fontSize = 16.sp,
            maxLines = 2,
            textAlign = TextAlign.Center
        )

    }
}


@Preview
@Composable
fun PreviewTeamInfo() {
    GameDayTheme {
      Row {
          TeamInfo(
              teamName = "Monarch Coyotes Varsity",
              iconUrl = "https://imagedelivery.net/ErrQpIaCOWR-Tz51PhN1zA/128f7a1e-f8f1-45f3-a2ad-8d2f04230700/128",
              Modifier.weight(1f)
          )
      }
    }
}

@Preview
@Composable
fun PreviewTeamNamesFullWidth() {
    GameDayTheme {
        TeamNamesFullWidth(
            homeName = "Colorado Avalanche",
            awayName = "Toronto Maple Leafs"
        )
    }
}

@Preview
@Composable
fun PreviewTeamButton() {
    GameDayTheme {
        Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
            TeamButton(team = avalanche, onClick = { } )
        }

    }
}

