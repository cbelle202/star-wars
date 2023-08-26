package com.ciarabelle.starwars.di

import com.ciarabelle.starwars.api.StarWarsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object StarWarsServiceFactory {
    private const val baseUrl = "https://swapi.dev"

    fun makeService(): StarWarsService {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create(StarWarsService::class.java)
    }
}
