package com.ciarabelle.starwars.utils

import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.Film

fun getTitle(any: Any): String? =
    when (any) {
        is Character -> any.name
        is Film -> any.title
        else -> null
    }
