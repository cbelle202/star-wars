package com.ciarabelle.starwars.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciarabelle.starwars.data.Character
import com.ciarabelle.starwars.data.CharacterList
import com.ciarabelle.starwars.data.Film
import com.ciarabelle.starwars.data.FilmList
import com.ciarabelle.starwars.data.StarWarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val repository: StarWarsRepository,
) : ViewModel() {

    var characterListState by mutableStateOf(null as CharacterList?)
        private set

    var characterState by mutableStateOf(null as Character?)
        private set

    var filmListState by mutableStateOf(null as FilmList?)
        private set

    var filmState by mutableStateOf(null as Film?)
        private set

    fun getCharacterList() {
        println("aaa----charlist---$characterListState")
        viewModelScope.launch {
            characterListState?.let { currList ->
                val nextUrl = currList.next
                if (currList.loading || nextUrl == null) return@launch
                characterListState = getNextPage(currList, nextUrl)
            } ?: run { characterListState = repository.getCharacterList() }
        }
    }

    fun setCharacter(character: Character?) {
        characterState = character
    }

    private suspend fun getNextPage(
        currList: CharacterList,
        nextUrl: String,
    ): CharacterList? {
        characterListState = currList.copy(loading = true)
        val characterList = repository.getCharacterList(nextUrl)
        val updatedList =
            (currList.results ?: listOf()) + (characterList?.results ?: listOf())
        return characterList?.copy(
            results = updatedList,
            loading = false,
        )
    }
}
