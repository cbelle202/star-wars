package com.ciarabelle.starwars.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciarabelle.starwars.components.LazyColumnComponent
import com.ciarabelle.starwars.components.ListItemComponent
import com.ciarabelle.starwars.navigation.CHARACTERS

@Composable
fun ResourcesScreen(
    modifier: Modifier = Modifier,
    onAction: (String) -> Unit,
) {
    val list = listOf(
        CHARACTERS,
    )
    LazyColumnComponent(modifier = modifier) {
        items(list) { item ->
            ListItemComponent(
                text = item,
                onAction = { onAction(item) },
            )
        }
    }
}
