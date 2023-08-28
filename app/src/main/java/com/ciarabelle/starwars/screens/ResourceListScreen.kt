package com.ciarabelle.starwars.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.ciarabelle.starwars.components.LazyColumnComponent
import com.ciarabelle.starwars.components.ListItemComponent
import com.ciarabelle.starwars.components.LoadingIndicatorComponent
import com.ciarabelle.starwars.data.ResourceList
import com.ciarabelle.starwars.utils.StringUtils

@Composable
fun ResourceListScreen(
    modifier: Modifier = Modifier,
    list: ResourceList,
    onGetList: () -> Unit,
    onResourceDetail: (Any) -> Unit,
) {
    Column {
        LazyColumnComponent(modifier = modifier) {
            list.results?.let {
                items(it) { item ->
                    ListItemComponent(
                        text = StringUtils.getTitle(item) ?: "No value",
                        onAction = { onResourceDetail(item) },
                    )
                }
            }
            item {
                LaunchedEffect(true) { onGetList() }
            }
        }
    }

    if (list.results == null || list.loading) {
        LoadingIndicatorComponent()
    }
}
