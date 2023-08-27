package com.ciarabelle.starwars.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItemComponent(
    modifier: Modifier = Modifier,
    text: String,
    onAction: () -> Unit,
) {
    Column {
        Text(
            modifier = modifier
                .background(Color.White.copy(alpha = .4f))
                .fillMaxWidth()
                .clickable { onAction() }
                .padding(all = 16.dp),
            text = text,
            fontSize = 22.sp,
        )
        Divider(thickness = Dp.Hairline, color = Color.Black)
    }
}
