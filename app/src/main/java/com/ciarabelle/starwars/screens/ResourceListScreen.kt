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
import com.ciarabelle.starwars.data.ResourceList
import com.ciarabelle.starwars.utils.getTitle

@Composable
fun ResourceListScreen(
    modifier: Modifier = Modifier,
    list: ResourceList?,
    onGetList: () -> Unit,
    onResourceDetail: (Any) -> Unit,
) {
    Column {
        Text("List---------- >_>", color = Color.White)
        LazyColumnComponent(modifier = modifier) {
            list?.results?.let {
                items(it) { item ->
                    ListItemComponent(
                        text = getTitle(item) ?: "No value",
                        onAction = { onResourceDetail(item) },
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
