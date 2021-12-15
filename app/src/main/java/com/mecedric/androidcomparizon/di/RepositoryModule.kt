package com.mecedric.androidcomparizon.di

import com.mecedric.androidcomparizon.api.ApiClient
import com.mecedric.androidcomparizon.data.persistence.PokemonDao
import com.mecedric.androidcomparizon.data.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideMainRepository(
        apiClient: ApiClient,
        pokemonDao: PokemonDao,
    ): PokemonRepository = PokemonRepository(apiClient, pokemonDao)

}
