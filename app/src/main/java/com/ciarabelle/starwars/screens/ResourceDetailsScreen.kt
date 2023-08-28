package com.ciarabelle.starwars.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
import com.ciarabelle.starwars.components.TitleComponent
import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.Film
import com.ciarabelle.starwars.data.Planet
import com.ciarabelle.starwars.utils.ImageUtils
import com.ciarabelle.starwars.utils.getTitle
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@Composable
fun ResourceDetailsScreen(any: Any?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState(),
                enabled = true,
            ),
    ) {
        val memberProperties = getMemberProperties(any)
        any?.let { obj ->
            memberProperties?.let { members ->
                PropertiesDisplay(any = obj, memberProperties = members)
            }
        }
    }
}

@Composable
private fun PropertiesDisplay(any: Any, memberProperties: Collection<KProperty1<Any, *>>) {
    val title = getTitle(any)
    title?.let { TitleComponent(text = title) }

    val image = ImageUtils.getImage(title)
    image?.let { AsyncImage(model = it, contentDescription = null) }

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

private fun getMemberProperties(any: Any?): Collection<KProperty1<Any, *>>? =
    when (any) {
        is Character -> Character::class.memberProperties as Collection<KProperty1<Any, *>>
        is Film -> Film::class.memberProperties as Collection<KProperty1<Any, *>>
        is Planet -> Planet::class.memberProperties as Collection<KProperty1<Any, *>>
        else -> null
    }
