package com.mecedric.androidcomparizon.modules.pokemons.services.data

import com.mecedric.androidcomparizon.data.persistence.AppDatabase
import com.mecedric.androidcomparizon.data.persistence.BaseDataService
import com.mecedric.androidcomparizon.modules.pokemons.services.data.impl.DataPokemonModel
import com.mecedric.androidcomparizon.preferences.AppPreferences

class DataServicePokemon(
    override val db: AppDatabase,
    override val preferences: AppPreferences,
) : BaseDataService<DataServicePokemon>,
    DataPokemonModel