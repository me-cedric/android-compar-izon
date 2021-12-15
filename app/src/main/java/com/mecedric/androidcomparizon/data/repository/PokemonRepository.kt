package com.mecedric.androidcomparizon.data.repository

import com.mecedric.androidcomparizon.api.ApiClient
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.data.model.response.PokemonResponse
import com.mecedric.androidcomparizon.data.persistence.PokemonDao
import com.mecedric.androidcomparizon.util.resultLiveData
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val pokemonDao: PokemonDao
) {

    fun observePokemon(id: Int) =
        resultLiveData(
            databaseQuery = { pokemonDao.getPokemon(id) },
            networkCall = { apiClient.getPokemon(id) },
            saveCallResult = { pokemonDao.insertPokemon(it) }
        )

    fun deletePokemonList() =
        pokemonDao.deleteAll()

    fun deletePokemon(pokemonId: Int) =
        pokemonDao.delete(pokemonId)

    fun getPokemonList() = resultLiveData<List<Pokemon>, PokemonResponse>(
        databaseQuery = { pokemonDao.getPokemonList() }
    )

    fun observePokemonList(limit: Int?, offset: Int?) = resultLiveData(
        databaseQuery = { pokemonDao.getPokemonList() },
        networkCall = { apiClient.getPokemons(limit, offset) },
        saveCallResult = { tr ->
            val elementsWithMappedIds = tr.results.map {
                // set the id to the one in url
                it.id = it.url.split("/").last { x -> x.isNotEmpty() }.toInt()
                it
            }
            pokemonDao.insertPokemonList(elementsWithMappedIds)
        }
    )
}
