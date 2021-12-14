package com.mecedric.androidcomparizon.data.converter

import androidx.room.TypeConverter
import com.mecedric.androidcomparizon.data.model.*
import com.mecedric.androidcomparizon.di.NetworkModule

/**
 * Generic class to convert Models to and from a json string.
 */
open class ModelConverter<T>(type: Class<T>) {

    private val jsonAdapter = NetworkModule.moshi.adapter(type)

    @TypeConverter
    fun fromString(value: String?): T? = value?.let { jsonAdapter.fromJson(value) }

    @TypeConverter
    fun fromType(type: T?): String? = type?.let { jsonAdapter.toJson(type) }
}

class PokemonConverter : ModelConverter<Pokemon>(Pokemon::class.java)