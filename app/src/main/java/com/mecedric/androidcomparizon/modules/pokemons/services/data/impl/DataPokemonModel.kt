package com.mecedric.androidcomparizon.modules.pokemons.services.data.impl

import androidx.paging.PagingSource
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.data.persistence.AppDatabase
import com.mecedric.androidcomparizon.modules.pokemons.data.dao.DaoPokemonModel
import com.mecedric.androidcomparizon.preferences.AppPreferences

interface DataPokemonModel {

    val db: AppDatabase
    val preferences: AppPreferences

    private val dao: DaoPokemonModel get() = db.pokemonDao()

    suspend fun insertPokemonModel(models: List<Pokemon>) {
        dao.insertPokemonModels(models)
    }

    suspend fun clearPokemonModel() {
        dao.clear()
    }

    suspend fun countPokemonModel(): Int {
        return dao.count()
    }

    fun pagingListBrandModel(): PagingSource<Int, Pokemon> {
        return dao.pagingSource()
    }
}