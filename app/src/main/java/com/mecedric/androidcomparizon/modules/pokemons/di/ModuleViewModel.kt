package com.mecedric.androidcomparizon.modules.pokemons.di

import com.mecedric.androidcomparizon.data.persistence.AppDatabase
import com.mecedric.androidcomparizon.modules.pokemons.services.api.ApiPokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.ApiServicePokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.data.DataServicePokemon
import com.mecedric.androidcomparizon.preferences.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    fun provideDataServiceCatalog(db: AppDatabase, preferences: AppPreferences) =
        DataServicePokemon(db, preferences)
}
