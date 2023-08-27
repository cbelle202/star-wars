package com.ciarabelle.starwars.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.ciarabelle.starwars.utils.getTitle

@Composable
fun TitleComponent(any: Any) {
    val title = getTitle(any)
    title?.let {
        Text(
            text = title,
            fontSize = 22.sp,
        )
    }
}
