package com.ciarabelle.starwars.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.ciarabelle.starwars.data.Character
import kotlin.reflect.full.memberProperties

@Composable
fun CharacterDetailsScreen(character: Character?) {
    Column {
        character?.let {
            Text(
                text = it.name ?: "No value",
                fontSize = 22.sp,
            )
            for (prop in Character::class.memberProperties) {
                if (prop.name == "name") continue
                println("${prop.name} = ${prop.get(character)}")
                Row {
                    Text(text = prop.name.plus(": "))
                    Text(text = prop.get(it).toString())
                }
            }
        }
    }
}
