package com.ciarabelle.starwars.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ciarabelle.starwars.navigation.CHARACTERS
import com.ciarabelle.starwars.navigation.ROOT

@Composable
fun CharactersScreen(onNavigate: () -> Unit) {
    Column {
        Text(text = CHARACTERS)
        Button(
            onClick = { onNavigate() },
        ) {
            Text(text = ROOT)
        }
    }
}
