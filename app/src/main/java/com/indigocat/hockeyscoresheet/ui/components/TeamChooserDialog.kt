package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.indigocat.hockeyscoresheet.R
import com.indigocat.hockeyscoresheet.data.api.model.Team
import com.indigocat.hockeyscoresheet.ui.components.data.avalanche
import com.indigocat.hockeyscoresheet.ui.components.data.mapleLeafs
import com.indigocat.hockeyscoresheet.ui.components.style.Header3
import com.indigocat.hockeyscoresheet.ui.theme.GameDayTheme


@Composable
fun TeamChooserDialog(
    homeTeam: Team,
    awayTeam: Team,
    onSelectTeam: (String) -> Unit,
    setShowDialog: (Boolean) -> Unit
) {
    Surface(Modifier.background(MaterialTheme.colorScheme.background)) {
        Dialog(
            onDismissRequest = { setShowDialog(false) }
        ) {
            Column {
                Header3(text = stringResource(id = R.string.team_chooser_title))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TeamButton(homeTeam, onSelectTeam, Modifier.weight(1f))
                    TeamButton(team = awayTeam, onClick = onSelectTeam, Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTeamChooserDialog() {
    GameDayTheme {
        TeamChooserDialog(
            homeTeam = avalanche,
            awayTeam = mapleLeafs ,
            onSelectTeam = { },
            setShowDialog = { }
        )
    }
}
