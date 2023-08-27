package com.ciarabelle.starwars.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciarabelle.starwars.data.CharacterList
import com.ciarabelle.starwars.data.FilmList
import com.ciarabelle.starwars.data.PlanetList
import com.ciarabelle.starwars.data.Resources
import com.ciarabelle.starwars.data.SpeciesList
import com.ciarabelle.starwars.data.StarWarsRepository
import com.ciarabelle.starwars.data.StarshipList
import com.ciarabelle.starwars.data.VehicleList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val repository: StarWarsRepository,
) : ViewModel() {

    var resourcesState by mutableStateOf(null as Resources?)
        private set

    var filmListState by mutableStateOf(null as FilmList?)
        private set

    var characterListState by mutableStateOf(null as CharacterList?)
        private set

    var planetListState by mutableStateOf(null as PlanetList?)
        private set

    var speciesListState by mutableStateOf(null as SpeciesList?)
        private set

    var starshipListState by mutableStateOf(null as StarshipList?)
        private set

    var vehicleListState by mutableStateOf(null as VehicleList?)
        private set

    fun getCharacterList() {
        println("aaa----charlist---$characterListState")
        viewModelScope.launch {
            characterListState?.let { list ->
                list.next?.let { nextUrl ->
                    if (nextUrl.toLowerCase(Locale.current) == "null") return@launch
                    val characterList = repository.getCharacterList(nextUrl)
                    characterListState = characterList
                }
            } ?: run {
                characterListState = repository.getCharacterList()
            }
        }
    }
}
