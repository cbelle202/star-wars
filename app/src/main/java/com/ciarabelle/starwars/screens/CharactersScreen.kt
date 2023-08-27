package com.ciarabelle.starwars.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ciarabelle.starwars.components.LazyColumnComponent
import com.ciarabelle.starwars.components.ListItemComponent
import com.ciarabelle.starwars.components.LoadingIndicatorComponent
import com.ciarabelle.starwars.data.CharacterList

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    list: CharacterList?,
    onGetList: () -> Unit,
) {
    LazyColumnComponent(modifier = modifier) {
        list?.results?.let {
            items(it) { char ->
                ListItemComponent(text = char.name ?: "No value", onAction = {})
            }
        }
        item {
            LaunchedEffect(true) { onGetList() }
        }
    }

    if (list == null || list.loading) {
        LoadingIndicatorComponent()
    }
}
