package com.mecedric.androidcomparizon.api.clientImpl

import com.mecedric.androidcomparizon.api.ApiService
import com.mecedric.androidcomparizon.util.BaseDataSource

interface ApiServiceGet : BaseDataSource {

    val api: ApiService

    suspend fun getPokemon(id: Int) = getResult {
        api.getPokemon(id)
    }

    suspend fun getPokemons(limit: Int?, offset: Int?) = getResult {
        api.getPokemons(limit, offset)
    }
}