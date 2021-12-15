package com.mecedric.androidcomparizon.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mecedric.androidcomparizon.data.converter.PokemonConverter
import com.mecedric.androidcomparizon.data.model.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    value = [
        PokemonConverter::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDao
}