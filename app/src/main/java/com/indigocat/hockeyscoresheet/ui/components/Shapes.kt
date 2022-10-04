package com.indigocat.hockeyscoresheet.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun RectangleOutline() {
    ExampleBox(shape = RoundedCornerShape(50.dp))
}

@Composable
fun ExampleBox(shape: Shape) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Box(modifier = Modifier
            .size(100.dp)
            .clip(shape)
            .background(MaterialTheme.colorScheme.primary)
        )
    }
}
