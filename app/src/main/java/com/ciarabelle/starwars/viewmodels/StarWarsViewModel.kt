package com.ciarabelle.starwars.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciarabelle.starwars.data.CharacterList
import com.ciarabelle.starwars.data.FilmList
import com.ciarabelle.starwars.data.ResourceList
import com.ciarabelle.starwars.data.StarWarsRepository
import com.ciarabelle.starwars.navigation.CHARACTERS
import com.ciarabelle.starwars.navigation.FILMS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val repository: StarWarsRepository,
) : ViewModel() {

    private var characterListState by mutableStateOf(CharacterList())

    private var filmListState by mutableStateOf(FilmList())

    var resourceListState by mutableStateOf(null as ResourceList?)
        private set

    var resourceDetailsState by mutableStateOf(null as Any?)
        private set

    fun getResourceList() {
        when (resourceListState) {
            is FilmList -> {
                getFilmList()
            }
            is CharacterList -> {
                getCharacterList()
            }
        }
    }

    fun setResourceList(type: String) {
        resourceListState = when (type) {
            CHARACTERS -> {
                characterListState
            }
            FILMS -> {
                filmListState
            }
            else -> null
        }
        println()
    }

    fun setResourceDetails(any: Any?) {
        resourceDetailsState = any
        println()
    }

    private fun getCharacterList() {
        println("aaa----charlist---$characterListState")
        viewModelScope.launch {
            characterListState.count?.let {
                val nextUrl = characterListState.next
                if (characterListState.loading || nextUrl == null) return@launch
                characterListState = getNextCharacterPage(characterListState, nextUrl)
            } ?: run {
                characterListState = repository.getCharacterList()
            }
            resourceListState = characterListState
        }
    }

    private suspend fun getNextCharacterPage(
        currList: CharacterList,
        nextUrl: String,
    ): CharacterList {
        characterListState = currList.copy(loading = true)
        resourceListState = characterListState
        val characterList = repository.getCharacterList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (characterList.results ?: listOf())
        return characterList.copy(
            results = updatedList,
            loading = false,
        )
    }

    private fun getFilmList() {
        println("aaa----filmlist---$filmListState")
        viewModelScope.launch {
            filmListState.count?.let {
                val nextUrl = filmListState.next
                if (filmListState.loading || nextUrl == null) return@launch
                filmListState = getNextFilmPage(filmListState, nextUrl)
            } ?: run {
                filmListState = repository.getFilmList()
            }
            resourceListState = filmListState
        }
    }

    private suspend fun getNextFilmPage(
        currList: FilmList,
        nextUrl: String,
    ): FilmList {
        filmListState = currList.copy(loading = true)
        resourceListState = filmListState
        val filmList = repository.getFilmList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (filmList.results ?: listOf())
        return filmList.copy(
            results = updatedList,
            loading = false,
        )
    }
}
