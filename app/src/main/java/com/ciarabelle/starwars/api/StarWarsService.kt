package com.ciarabelle.starwars.api

import com.ciarabelle.starwars.data.Resources
import retrofit2.Response
import retrofit2.http.GET

interface StarWarsService {
    @GET("/api")
    suspend fun getResources(): Response<Resources>
}