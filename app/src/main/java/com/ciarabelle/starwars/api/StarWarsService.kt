package com.ciarabelle.starwars.api

import com.ciarabelle.starwars.data.CharacterList
import com.ciarabelle.starwars.data.FilmList
import com.ciarabelle.starwars.data.PlanetList
import com.ciarabelle.starwars.data.SpeciesList
import com.ciarabelle.starwars.data.StarshipList
import com.ciarabelle.starwars.data.VehicleList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsService {

    @GET("/api/people")
    suspend fun getCharacterList(@Query("page") page: String? = null): Response<CharacterList>

    @GET("/api/films")
    suspend fun getFilmList(): Response<FilmList>

    @GET("/api/planets")
    suspend fun getPlanetList(): Response<PlanetList>

    @GET("/api/species")
    suspend fun getSpeciesList(): Response<SpeciesList>

    @GET("/api/starships")
    suspend fun getStarShipList(): Response<StarshipList>

    @GET("/api/vehicles")
    suspend fun getVehicleList(): Response<VehicleList>
}
