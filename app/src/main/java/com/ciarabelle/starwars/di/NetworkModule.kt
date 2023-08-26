package com.ciarabelle.starwars.di

import com.ciarabelle.starwars.api.StarWarsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideStarWarsService(): StarWarsService {
        return StarWarsServiceFactory.makeService()
    }
}