package com.ciarabelle.starwars.utils

import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.Film
import com.ciarabelle.starwars.data.Planet
import com.ciarabelle.starwars.data.Species
import com.ciarabelle.starwars.data.Starship
import com.ciarabelle.starwars.data.Vehicle

object StringUtils {
    fun getTitle(any: Any): String? =
        when (any) {
            is Character -> any.name
            is Film -> any.title
            is Planet -> any.name
            is Species -> any.name
            is Starship -> any.name
            is Vehicle -> any.name
            else -> null
        }
}
