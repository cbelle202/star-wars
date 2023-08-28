package com.ciarabelle.starwars.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun TitleComponent(text: String) {
    Text(text = text, fontSize = 22.sp)
}
