package com.ciarabelle.starwars.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ciarabelle.starwars.components.LazyColumnComponent
import com.ciarabelle.starwars.components.ListItemComponent
import com.ciarabelle.starwars.navigation.CHARACTER_LIST

@Composable
fun ResourcesScreen(
    modifier: Modifier = Modifier,
    onAction: (String) -> Unit,
) {
    val list = listOf(
        CHARACTER_LIST,
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
