package com.indigocat.hockeyscoresheet.ui.components.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.indigocat.hockeyscoresheet.ui.theme.HockeyScoreSheetTheme
import com.indigocat.hockeyscoresheet.ui.theme.dark_onSurface
import com.indigocat.hockeyscoresheet.ui.theme.dark_onSurfaceVariant
import com.indigocat.hockeyscoresheet.ui.theme.light_onSurface
import com.indigocat.hockeyscoresheet.ui.theme.light_onSurfaceVariant
import com.indigocat.hockeyscoresheet.ui.theme.light_primary


@Composable
fun Label1(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 14.sp
    )
}

@Composable
fun Label2(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 16.sp
    )
}


@Composable
fun Label3(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 18.sp,
        fontWeight = FontWeight(400)
    )
}

@Composable
fun Label4(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight(400)
    )
}
@Composable
fun Label5(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 22.sp,
        fontWeight = FontWeight(400)
    )
}

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun Header1(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 26.sp,
        fontWeight = FontWeight(600)
    )
}
@Composable
fun Header2(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 28.sp,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun Header3(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 30.sp,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun Header4(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 32.sp,
        fontWeight = FontWeight(600)
    )
}
@Composable
fun Header5(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 36.sp,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun FinalScore(text: String, didWin: Boolean = false, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 36.sp,
        fontWeight = if (didWin) FontWeight(600) else FontWeight(400),
        color = if (isSystemInDarkTheme()) {
            if (didWin) dark_onSurface else dark_onSurfaceVariant
        } else {
            if (didWin) light_onSurface else light_onSurfaceVariant
        }
    )
}

@Composable
fun ContrastHeader(text:String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier,
        fontSize = 24.sp,
        color = light_primary,
        fontWeight = FontWeight(600)
    )
}

@Composable
fun BoldText(text: String, modifier: Modifier = Modifier) {
    Text(
        text, 
        modifier,
        fontWeight = FontWeight(600)
    )
}

@Preview
@Composable
fun PreviewTextStyles() {
    HockeyScoreSheetTheme() {
        Column {
            BoldText(text = "BoldText")
            Label1(text = "Label1")
            Label2(text = "Label2")
            Label3(text = "Label3")
            Label4(text = "Label4")
            Label5(text = "Label5")
            Header(text ="Header")
            Header1(text ="Header1")
            Header2(text ="Header2")
            Header3(text ="Header3")
            Header4("Header 4")
            ContrastHeader(text ="ContrastHeader")
            FinalScore("FinalScore loss")
            FinalScore("FinalScore win", true)
        }
    }
}
