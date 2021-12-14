package com.mecedric.androidcomparizon.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonImage")
    fun getAll(): Flow<List<PokemonImage>>

    @Query("SELECT * FROM PokemonImage WHERE imageName==:name")
    suspend fun getItemByName(name: String): List<PokemonImage>

    @Query("DELETE FROM PokemonImage WHERE imageName==:id")
    suspend fun deleteBookmark(id: String)

    @Insert
    suspend fun insertAll(vararg bookmarkImage: PokemonImage)

    @Insert
    suspend fun insert(bookmarkImage: PokemonImage)

    @Delete
    suspend fun delete(bookmarkImage: PokemonImage)
}