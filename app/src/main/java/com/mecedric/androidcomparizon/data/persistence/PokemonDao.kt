package com.mecedric.androidcomparizon.data.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mecedric.androidcomparizon.data.model.Pokemon

@Dao
interface PokemonDao {
    @Transaction
    fun deleteAndCreatePokemonList(pokemonList: List<Pokemon>) {
        deleteAll()
        insertPokemonList(pokemonList)
    }

    @Query("DELETE FROM Pokemon")
    fun deleteAll()

    @Query("DELETE FROM Pokemon WHERE name = :name_")
    fun delete(name_: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonList(pokemonList: List<Pokemon>)

    @Update
    fun updatePokemon(pokemon: Pokemon)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM Pokemon")
    fun getPokemonList(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM Pokemon WHERE name = :name_")
    fun getPokemon(name_: Int): LiveData<Pokemon>
}