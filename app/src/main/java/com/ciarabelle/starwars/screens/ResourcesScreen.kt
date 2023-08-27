package com.ciarabelle.starwars.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciarabelle.starwars.navigation.CHARACTERS

@Composable
fun ResourcesScreen(
    modifier: Modifier = Modifier,
    onAction: (String) -> Unit,
) {
    val list = listOf(
        CHARACTERS,
    )
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .background(Color.Yellow.copy(alpha = .6f)),
    ) {
        items(list) { item ->
            ResourceListItem(
                text = item,
                onAction = { onAction(item) },
            )
            Divider(thickness = Dp.Hairline, color = Color.Black)
        }
    }
}

@Composable
fun ResourceListItem(
    modifier: Modifier = Modifier,
    text: String,
    onAction: () -> Unit,
) {
    Text(
        modifier = modifier
            .background(Color.White.copy(alpha = .4f))
            .fillMaxWidth()
            .clickable { onAction() }
            .padding(all = 16.dp),
        text = text,
        fontSize = 22.sp,
    )
}
