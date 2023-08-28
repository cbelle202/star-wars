package com.ciarabelle.starwars.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ciarabelle.starwars.components.LazyColumnComponent
import com.ciarabelle.starwars.components.ListItemComponent
import com.ciarabelle.starwars.navigation.CHARACTERS
import com.ciarabelle.starwars.navigation.FILMS
import com.ciarabelle.starwars.navigation.PLANETS
import com.ciarabelle.starwars.navigation.SPECIES

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAction: (String) -> Unit,
) {
    val list = listOf(
        CHARACTERS,
        FILMS,
        PLANETS,
        SPECIES,
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
