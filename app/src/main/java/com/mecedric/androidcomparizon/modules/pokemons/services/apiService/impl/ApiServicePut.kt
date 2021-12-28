package com.mecedric.androidcomparizon.modules.pokemons.services.apiService.impl

import com.mecedric.androidcomparizon.modules.pokemons.services.api.ApiPokemon
import com.mecedric.androidcomparizon.util.BaseDataSource

interface ApiServicePut : BaseDataSource {
    val api: ApiPokemon
}