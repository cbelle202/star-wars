package com.ciarabelle.starwars.data

import com.ciarabelle.starwars.api.StarWarsService
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val service: StarWarsService,
) {
    private var charMap = mutableMapOf<String, Character>()
    private var filmMap = mutableMapOf<String, Film>()

    suspend fun getCharacterList(nextUrl: String? = null): CharacterList {
        val page = parsePageFromUrl(nextUrl)
        println("aaa----page-- $page")
        val characterList = service.getCharacterList(page).body()
        /*characterList?.results?.let { list ->
            list.forEach { char ->
                char.url?.let { charMap[it] = char }
            }
        }*/
        return characterList ?: CharacterList()
    }

    private fun parsePageFromUrl(nextUrl: String?): String? {
        val match = "page="
        return nextUrl?.let {
            val index = it.indexOf(match) + match.length
            it.substring(IntRange(index, it.length - 1))
        }
    }

    suspend fun getFilmList(nextUrl: String? = null): FilmList {
        val page = parsePageFromUrl(nextUrl)
        val filmList = service.getFilmList(page).body()
        /*characterList?.results?.let { list ->
            list.forEach { char ->
                char.url?.let { charMap[it] = char }
            }
        }*/
        return filmList ?: FilmList()
    }
}
