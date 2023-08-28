package com.ciarabelle.starwars.utils

object ImageUtils {
    fun getImage(name: String?): String? {
        return when (name) {
            "Luke Skywalker" -> "https://lumiere-a.akamaihd.net/v1/images/luke-skywalker-main_7ffe21c7.jpeg"
            "Darth Vader" -> "https://imageio.forbes.com/specials-images/imageserve/6090f7f251c9c6c605e612fc/Darth-Vader/0x0.jpg"
            else -> null
        }
    }
}
