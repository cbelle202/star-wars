package com.ciarabelle.starwars.data

import com.ciarabelle.starwars.api.StarWarsService
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val service: StarWarsService,
) {
    suspend fun getCharacterList(nextUrl: String? = null): CharacterList {
        val page = parsePageFromUrl(nextUrl)
        println("aaa----page-- $page")
        val characterList = service.getCharacterList(page).body()
        return characterList ?: CharacterList()
    }

    suspend fun getNextCharacterPage(
        currList: CharacterList,
        nextUrl: String,
    ): CharacterList {
        val characterList = getCharacterList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (characterList.results ?: listOf())
        return characterList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getFilmList(nextUrl: String? = null): FilmList {
        val page = parsePageFromUrl(nextUrl)
        val filmList = service.getFilmList(page).body()
        return filmList ?: FilmList()
    }

    suspend fun getNextFilmPage(
        currList: FilmList,
        nextUrl: String,
    ): FilmList {
        val filmList = getFilmList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (filmList.results ?: listOf())
        return filmList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getPlanetList(nextUrl: String? = null): PlanetList {
        val page = parsePageFromUrl(nextUrl)
        val planetList = service.getPlanetList(page).body()
        return planetList ?: PlanetList()
    }

    suspend fun getNextPlanetPage(
        currList: PlanetList,
        nextUrl: String,
    ): PlanetList {
        val planetList = getPlanetList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (planetList.results ?: listOf())
        return planetList.copy(
            results = updatedList,
            loading = false,
        )
    }

    private fun parsePageFromUrl(nextUrl: String?): String? {
        val match = "page="
        return nextUrl?.let {
            val index = it.indexOf(match) + match.length
            it.substring(IntRange(index, it.length - 1))
        }
    }
}
