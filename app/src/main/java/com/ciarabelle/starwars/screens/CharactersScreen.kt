package com.ciarabelle.starwars.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ciarabelle.starwars.data.Character

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    list: List<Character>?,
    onGetList: () -> Unit,
) {
    LaunchedEffect(true) { onGetList() }
    list?.let { charList ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black)
                .background(Color.Yellow.copy(alpha = .6f)),
        ) {
            items(charList) {
                Text(text = it.name ?: "No value")
            }
            item {
                Button(onClick = { onGetList() }) {
                    Text("Fetch")
                }
            }
        }
    }
}
