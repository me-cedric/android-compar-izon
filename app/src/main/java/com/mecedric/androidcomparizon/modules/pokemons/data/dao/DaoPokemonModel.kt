package com.mecedric.androidcomparizon.modules.pokemons.data.dao

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.*
import com.mecedric.androidcomparizon.data.model.Pokemon

@Dao
interface DaoPokemonModel {

    @Transaction
    fun deleteAndCreatePokemonList(pokemonList: List<Pokemon>) {
        clear()
        insertPokemonModels(pokemonList)
    }

    @Query("DELETE FROM Pokemon")
    fun clear()

    @Query("SELECT COUNT(*) FROM Pokemon")
    fun count(): Int

    @Query("DELETE FROM Pokemon WHERE name = :name_")
    fun delete(name_: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonModels(pokemonList: List<Pokemon>)

    @Update
    fun updatePokemon(pokemon: Pokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM Pokemon")
    fun getPokemonList(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM Pokemon WHERE name = :name_")
    fun getPokemon(name_: Int): LiveData<Pokemon>

    @Query("SELECT * FROM Pokemon")
    fun pagingSource(): PagingSource<Int, Pokemon>
}
