package com.mecedric.androidcomparizon.modules.pokemons.data.repository

import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.data.model.response.PokemonResponse
import com.mecedric.androidcomparizon.modules.pokemons.data.dao.DaoPokemonModel
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.ApiServicePokemon
import com.mecedric.androidcomparizon.util.resultLiveData
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiClient: ApiServicePokemon,
    private val pokemonDao: DaoPokemonModel
) {

    fun observePokemon(id: Int) =
        resultLiveData(
            databaseQuery = { pokemonDao.getPokemon(id) },
            networkCall = { apiClient.getPokemon(id) },
            saveCallResult = { pokemonDao.insertPokemon(it) }
        )

    fun deletePokemonList() =
        pokemonDao.clear()

    fun deletePokemon(pokemonId: Int) =
        pokemonDao.delete(pokemonId)

    fun getPokemonList() = resultLiveData<List<Pokemon>, PokemonResponse>(
        databaseQuery = { pokemonDao.getPokemonList() }
    )

    fun observePokemonList(offset: Int) = resultLiveData(
        databaseQuery = { pokemonDao.getPokemonList() },
        networkCall = { apiClient.getListPokemons(offset) },
        saveCallResult = { tr ->
            val elementsWithMappedIds = tr.results.map {
                // set the id to the one in url
                it.id = it.url.split("/").last { x -> x.isNotEmpty() }.toInt()
                it
            }
            pokemonDao.insertPokemonModels(elementsWithMappedIds)
        }
    )
}
