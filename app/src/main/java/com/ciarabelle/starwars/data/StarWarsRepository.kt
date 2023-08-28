package com.ciarabelle.starwars.data

import com.ciarabelle.starwars.api.StarWarsService
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val service: StarWarsService,
) {
    suspend fun getCharacterList(nextUrl: String? = null): CharacterList {
        var list = CharacterList()
        try {
            val page = parsePageFromUrl(nextUrl)
            list = service.getCharacterList(page).body() ?: CharacterList()
        } catch (e: Exception) {
            println("failed to get characters $e")
        }
        return list
    }

    suspend fun getNextCharacterPage(
        currList: CharacterList,
        nextUrl: String,
    ): CharacterList {
        val newList = getCharacterList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (newList.results ?: listOf())
        return newList.copy(
            results = updatedList,
            loading = false,
        )
    }

    suspend fun getFilmList(nextUrl: String? = null): FilmList {
        var list = FilmList()
        try {
            val page = parsePageFromUrl(nextUrl)
            list = service.getFilmList(page).body() ?: FilmList()
        } catch (e: Exception) {
            println("failed to get films $e")
        }
        return list
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
        var list = PlanetList()
        try {
            val page = parsePageFromUrl(nextUrl)
            list = service.getPlanetList(page).body() ?: PlanetList()
        } catch (e: Exception) {
            println("failed to get planets $e")
        }
        return list
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
        var list = SpeciesList()
        try {
            val page = parsePageFromUrl(nextUrl)
            list = service.getSpeciesList(page).body() ?: SpeciesList()
        } catch (e: Exception) {
            println("failed to get species $e")
        }
        return list
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
        var list = StarshipList()
        try {
            val page = parsePageFromUrl(nextUrl)
            list = service.getStarShipList(page).body() ?: StarshipList()
        } catch (e: Exception) {
            println("failed to get starships $e")
        }
        return list
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
        var list = VehicleList()
        try {
            val page = parsePageFromUrl(nextUrl)
            list = service.getVehicleList(page).body() ?: VehicleList()
        } catch (e: Exception) {
            println("failed to get vehicles $e")
        }
        return list
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
