package com.ciarabelle.starwars.data

import com.ciarabelle.starwars.api.StarWarsService
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val service: StarWarsService,
) {
    suspend fun getResources(): Resources? {
        return service.getResources().body()
    }

    suspend fun getCharacterList(nextUrl: String? = null): CharacterList? {
        val page = parsePageFromUrl(nextUrl)
        println("aaa----page-- $page")
        return service.getCharacterList(page).body()
    }

    private fun parsePageFromUrl(nextUrl: String?): String? {
        val match = "page="
        return nextUrl?.let {
            val index = it.indexOf(match) + match.length
            it.substring(IntRange(index, index))
        }
    }

    suspend fun getFilmList(): FilmList? {
        return service.getFilmList().body()
    }
}
