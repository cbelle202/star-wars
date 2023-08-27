package com.ciarabelle.starwars.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.Film
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@Composable
fun DetailsScreen(any: Any?) {
    Column {
        val memberProperties = when (any) {
            is Character -> Character::class.memberProperties as Collection<KProperty1<Any, *>>
            is Film -> Film::class.memberProperties as Collection<KProperty1<Any, *>>
            else -> null
        }
        any?.let { obj ->
            memberProperties?.let { members ->
                PropertiesDisplay(any = obj, memberProperties = members)
            }
        }
    }
}

@Composable
private fun PropertiesDisplay(any: Any, memberProperties: Collection<KProperty1<Any, *>>) {
    Title(any = any)
    for (prop in memberProperties) {
        if (prop.name == "name" || prop.name == "title") continue
        println("${prop.name} = ${prop.get(any)}")
        Row {
            Text(
                text = prop.name.plus(": "),
                color = Color.Cyan,
            )
            Text(text = prop.get(any).toString())
        }
    }
}

@Composable
private fun Title(any: Any) {
    val title = when (any) {
        is Character -> any.name
        is Film -> any.title
        else -> null
    }
    title?.let {
        Text(
            text = title,
            fontSize = 22.sp,
        )
    }
}
