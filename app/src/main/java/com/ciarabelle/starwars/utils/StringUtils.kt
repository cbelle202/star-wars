package com.ciarabelle.starwars.utils

import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.Film
import com.ciarabelle.starwars.data.Planet

object StringUtils {
    fun getTitle(any: Any): String? =
        when (any) {
            is Character -> any.name
            is Film -> any.title
            is Planet -> any.name
            else -> null
        }
}
