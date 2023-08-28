package com.ciarabelle.starwars.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciarabelle.starwars.data.CharacterList
import com.ciarabelle.starwars.data.FilmList
import com.ciarabelle.starwars.data.PlanetList
import com.ciarabelle.starwars.data.ResourceList
import com.ciarabelle.starwars.data.SpeciesList
import com.ciarabelle.starwars.data.StarWarsRepository
import com.ciarabelle.starwars.data.StarshipList
import com.ciarabelle.starwars.data.VehicleList
import com.ciarabelle.starwars.navigation.CHARACTERS
import com.ciarabelle.starwars.navigation.FILMS
import com.ciarabelle.starwars.navigation.PLANETS
import com.ciarabelle.starwars.navigation.SPECIES
import com.ciarabelle.starwars.navigation.STARSHIPS
import com.ciarabelle.starwars.navigation.VEHICLES
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val repository: StarWarsRepository,
) : ViewModel() {
    private var characterListState by mutableStateOf(CharacterList())
    private var filmListState by mutableStateOf(FilmList())
    private var planetListState by mutableStateOf(PlanetList())
    private var speciesListState by mutableStateOf(SpeciesList())
    private var starshipListState by mutableStateOf(StarshipList())
    private var vehicleListState by mutableStateOf(VehicleList())

    var resourceListState by mutableStateOf(ResourceList())
        private set
    var resourceDetailsState by mutableStateOf(null as Any?)
        private set

    fun getResourceList() {
        when (resourceListState) {
            is FilmList -> getFilmList()
            is CharacterList -> getCharacterList()
            is PlanetList -> getPlanetList()
            is SpeciesList -> getSpeciesList()
            is StarshipList -> getStarshipList()
            is VehicleList -> getVehicleList()
        }
    }

    fun setResourceList(type: String) {
        resourceListState = when (type) {
            CHARACTERS -> characterListState
            FILMS -> filmListState
            PLANETS -> planetListState
            SPECIES -> speciesListState
            STARSHIPS -> starshipListState
            VEHICLES -> vehicleListState
            else -> ResourceList()
        }
    }

    fun setResourceDetails(any: Any?) {
        resourceDetailsState = any
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            characterListState = characterListState.count?.let {
                val nextUrl = characterListState.next
                if (characterListState.loading || nextUrl == null) return@launch
                resourceListState = characterListState.copy(loading = true)
                repository.getNextCharacterPage(characterListState, nextUrl)
            } ?: run {
                repository.getCharacterList()
            }
            if (resourceListState is CharacterList) {
                resourceListState = characterListState
            }
        }
    }

    private fun getFilmList() {
        viewModelScope.launch {
            filmListState = filmListState.count?.let {
                val nextUrl = filmListState.next
                if (filmListState.loading || nextUrl == null) return@launch
                resourceListState = filmListState.copy(loading = true)
                repository.getNextFilmPage(filmListState, nextUrl)
            } ?: run {
                repository.getFilmList()
            }
            if (resourceListState is FilmList) {
                resourceListState = filmListState
            }
        }
    }

    private fun getPlanetList() {
        viewModelScope.launch {
            planetListState = planetListState.count?.let {
                val nextUrl = planetListState.next
                if (planetListState.loading || nextUrl == null) return@launch
                resourceListState = planetListState.copy(loading = true)
                repository.getNextPlanetPage(planetListState, nextUrl)
            } ?: run {
                repository.getPlanetList()
            }
            if (resourceListState is PlanetList) {
                resourceListState = planetListState
            }
        }
    }

    private fun getSpeciesList() {
        viewModelScope.launch {
            speciesListState = speciesListState.count?.let {
                val nextUrl = speciesListState.next
                if (speciesListState.loading || nextUrl == null) return@launch
                resourceListState = speciesListState.copy(loading = true)
                repository.getNextSpeciesPage(speciesListState, nextUrl)
            } ?: run {
                repository.getSpeciesList()
            }
            if (resourceListState is SpeciesList) {
                resourceListState = speciesListState
            }
        }
    }

    private fun getStarshipList() {
        viewModelScope.launch {
            starshipListState = starshipListState.count?.let {
                val nextUrl = starshipListState.next
                if (starshipListState.loading || nextUrl == null) return@launch
                resourceListState = starshipListState.copy(loading = true)
                repository.getNextStarshipPage(starshipListState, nextUrl)
            } ?: run {
                repository.getStarshipList()
            }
            if (resourceListState is StarshipList) {
                resourceListState = starshipListState
            }
        }
    }

    private fun getVehicleList() {
        viewModelScope.launch {
            vehicleListState = vehicleListState.count?.let {
                val nextUrl = vehicleListState.next
                if (vehicleListState.loading || nextUrl == null) return@launch
                resourceListState = vehicleListState.copy(loading = true)
                repository.getNextVehiclePage(vehicleListState, nextUrl)
            } ?: run {
                repository.getVehicleList()
            }
            if (resourceListState is VehicleList) {
                resourceListState = vehicleListState
            }
        }
    }
}
