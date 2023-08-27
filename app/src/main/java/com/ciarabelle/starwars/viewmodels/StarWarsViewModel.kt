package com.ciarabelle.starwars.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciarabelle.starwars.data.CharacterList
import com.ciarabelle.starwars.data.Film
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

    var resourceListState by mutableStateOf(null as ResourceList?)
        private set

    var characterListState by mutableStateOf(null as CharacterList?)
        private set

    var resourceDetailsState by mutableStateOf(null as Any?)
        private set

    var filmListState by mutableStateOf(null as FilmList?)
        private set

    var filmState by mutableStateOf(null as Film?)
        private set

    fun getResourceList() {
        when (resourceListState) {
            is CharacterList? -> getCharacterList()
        }
    }

    fun setResourceList(type: String) {
        when (type) {
            CHARACTERS -> resourceListState = characterListState
            FILMS -> resourceListState = filmListState
        }
    }

    fun setResourceDetails(any: Any?) {
        resourceDetailsState = any
    }

    private fun getCharacterList() {
        println("aaa----charlist---$characterListState")
        viewModelScope.launch {
            characterListState?.let { currList ->
                val nextUrl = currList.next
                if (currList.loading || nextUrl == null) return@launch
                characterListState = getNextPage(currList, nextUrl)
            } ?: run {
                characterListState = repository.getCharacterList()
            }
            resourceListState = characterListState
        }
    }

    private suspend fun getNextPage(
        currList: CharacterList,
        nextUrl: String,
    ): CharacterList? {
        characterListState = currList.copy(loading = true)
        resourceListState = characterListState
        val characterList = repository.getCharacterList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (characterList?.results ?: listOf())
        return characterList?.copy(
            results = updatedList,
            loading = false,
        )
    }
}
