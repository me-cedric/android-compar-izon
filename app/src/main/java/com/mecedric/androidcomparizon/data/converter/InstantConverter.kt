package com.mecedric.androidcomparizon.data.converter

import androidx.room.TypeConverter
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.time.Instant

/**
 * Convert an instant date to and from a json string
 */
class InstantConverter {
    @FromJson
    @TypeConverter
    fun fromString(value: String?): Instant? = value?.let { Instant.parse(it) }

    @ToJson
    @TypeConverter
    fun dateToString(date: Instant?): String? = date?.toString()
}