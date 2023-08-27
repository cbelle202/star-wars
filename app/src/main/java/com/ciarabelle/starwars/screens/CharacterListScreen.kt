package com.ciarabelle.starwars.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ciarabelle.starwars.components.LazyColumnComponent
import com.ciarabelle.starwars.components.ListItemComponent
import com.ciarabelle.starwars.components.LoadingIndicatorComponent
import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.CharacterList

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    list: CharacterList?,
    onGetList: () -> Unit,
    onCharacterDetail: (Character) -> Unit,
) {
    Column {
        Text("Character List", color = Color.White)
        LazyColumnComponent(modifier = modifier) {
            list?.results?.let {
                items(it) { char ->
                    ListItemComponent(
                        text = char.name ?: "No value",
                        onAction = { onCharacterDetail(char) },
                    )
                }
            }
            item {
                LaunchedEffect(true) { onGetList() }
            }
        }
    }

    if (list == null || list.loading) {
        LoadingIndicatorComponent()
    }
}
