package com.mecedric.androidcomparizon.modules.pokemons.services.apiService.impl

import com.mecedric.androidcomparizon.modules.pokemons.services.api.ApiPokemon
import com.mecedric.androidcomparizon.util.BaseDataSource

interface ApiServiceGet : BaseDataSource {

    val api: ApiPokemon

    suspend fun getPokemon(id: Int) = getResult {
        api.getPokemon(id)
    }

    suspend fun getListPokemons(page: Int) = getResult {
        api.getPokemons(page)
    }
}