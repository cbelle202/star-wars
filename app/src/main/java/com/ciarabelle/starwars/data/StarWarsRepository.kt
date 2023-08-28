package com.ciarabelle.starwars.data

import com.ciarabelle.starwars.api.StarWarsService
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val service: StarWarsService,
) {
    suspend fun getCharacterList(nextUrl: String? = null): CharacterList {
        val page = parsePageFromUrl(nextUrl)
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
        val list = service.getFilmList(page).body()
        return list ?: FilmList()
    }

    suspend fun getNextFilmPage(
        currList: FilmList,
        nextUrl: String,
    ): FilmList {
        val nextList = getFilmList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (nextList.results ?: listOf())
        return nextList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getPlanetList(nextUrl: String? = null): PlanetList {
        val page = parsePageFromUrl(nextUrl)
        val list = service.getPlanetList(page).body()
        return list ?: PlanetList()
    }

    suspend fun getNextPlanetPage(
        currList: PlanetList,
        nextUrl: String,
    ): PlanetList {
        val nextList = getPlanetList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (nextList.results ?: listOf())
        return nextList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getSpeciesList(nextUrl: String? = null): SpeciesList {
        val page = parsePageFromUrl(nextUrl)
        val list = service.getSpeciesList(page).body()
        return list ?: SpeciesList()
    }

    suspend fun getNextSpeciesPage(
        currList: SpeciesList,
        nextUrl: String,
    ): SpeciesList {
        val nextList = getSpeciesList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (nextList.results ?: listOf())
        return nextList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getStarshipList(nextUrl: String? = null): StarshipList {
        val page = parsePageFromUrl(nextUrl)
        val list = service.getStarShipList(page).body()
        return list ?: StarshipList()
    }

    suspend fun getNextStarshipPage(
        currList: StarshipList,
        nextUrl: String,
    ): StarshipList {
        val nextList = getStarshipList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (nextList.results ?: listOf())
        return nextList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getVehicleList(nextUrl: String? = null): VehicleList {
        val page = parsePageFromUrl(nextUrl)
        val list = service.getVehicleList(page).body()
        return list ?: VehicleList()
    }

    suspend fun getNextVehiclePage(
        currList: VehicleList,
        nextUrl: String,
    ): VehicleList {
        val nextList = getVehicleList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (nextList.results ?: listOf())
        return nextList.copy(
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
