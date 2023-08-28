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
import com.ciarabelle.starwars.data.StarWarsRepository
import com.ciarabelle.starwars.navigation.CHARACTERS
import com.ciarabelle.starwars.navigation.FILMS
import com.ciarabelle.starwars.navigation.PLANETS
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

    var resourceListState by mutableStateOf(ResourceList())
        private set
    var resourceDetailsState by mutableStateOf(null as Any?)
        private set

    fun getResourceList() {
        when (resourceListState) {
            is FilmList -> getFilmList()
            is CharacterList -> getCharacterList()
            is PlanetList -> getPlanetList()
        }
    }

    fun setResourceList(type: String) {
        resourceListState = when (type) {
            CHARACTERS -> characterListState
            FILMS -> filmListState
            PLANETS -> planetListState
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
}
