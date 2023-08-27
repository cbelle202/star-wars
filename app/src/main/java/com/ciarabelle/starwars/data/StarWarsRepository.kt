package com.ciarabelle.starwars.data

import com.ciarabelle.starwars.api.StarWarsService
import javax.inject.Inject

class StarWarsRepository @Inject constructor(
    private val service: StarWarsService,
) {
    suspend fun getResources(): Resources? {
        return service.getResources().body()
    }

    suspend fun getCharacterList(): CharacterList? {
        return service.getCharacterList().body()
    }

    suspend fun getFilmList(): FilmList? {
        return service.getFilmList().body()
    }
}
