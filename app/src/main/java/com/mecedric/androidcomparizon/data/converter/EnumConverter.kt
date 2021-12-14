package com.mecedric.androidcomparizon.data.converter

import androidx.room.TypeConverter
import com.mecedric.androidcomparizon.di.NetworkModule

/**
 * Generic class to convert Enums to and from a json string.
 */
open class EnumConverter<T : Enum<T>>(enumType: Class<T>) {

    private val jsonAdapter = NetworkModule.moshi.adapter(enumType)

    @TypeConverter
    fun fromString(value: String?): T? = value?.let { jsonAdapter.fromJson(value) }

    @TypeConverter
    fun fromEnum(type: T?): String? = type?.let { jsonAdapter.toJson(type) }
}

//class EmergencyConverter : EnumConverter<Emergency>(Emergency::class.java)