package com.ciarabelle.starwars.utils

object ImageUtils {
    fun getImage(name: String?): String? {
        return when (name) {
            "Luke Skywalker" -> "https://icons.iconarchive.com/icons/jonathan-rey/star-wars-characters/256/Luke-Skywalker-03-icon.png"
            else -> null
        }
    }
}
