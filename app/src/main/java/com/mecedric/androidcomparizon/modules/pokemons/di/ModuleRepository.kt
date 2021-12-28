package com.mecedric.androidcomparizon.modules.pokemons.di

import com.mecedric.androidcomparizon.modules.pokemons.data.dao.DaoPokemonModel
import com.mecedric.androidcomparizon.modules.pokemons.data.repository.PokemonRepository
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.ApiServicePokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object ModuleRepository {

    @Provides
    @ActivityRetainedScoped
    fun provideMainRepository(
        apiClient: ApiServicePokemon,
        pokemonDao: DaoPokemonModel,
    ): PokemonRepository = PokemonRepository(apiClient, pokemonDao)

}
