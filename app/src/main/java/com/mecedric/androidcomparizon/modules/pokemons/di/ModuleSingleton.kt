package com.mecedric.androidcomparizon.modules.pokemons.di

import com.mecedric.androidcomparizon.modules.pokemons.services.api.ApiPokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.ApiServicePokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleSingleton {

    @Provides
    @Singleton
    fun provideApiPokemon(retrofit: Retrofit): ApiPokemon = retrofit.create(ApiPokemon::class.java)

    @Provides
    @Singleton
    fun provideApiPokemonClient(apiService: ApiPokemon): ApiServicePokemon = ApiServicePokemon(apiService)
}
