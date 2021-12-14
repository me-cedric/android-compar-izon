package com.mecedric.androidcomparizon.data.converter

import androidx.room.TypeConverter
import com.mecedric.androidcomparizon.di.NetworkModule
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types


/**
 * Generic class to convert Lists to and from a json string.
 */
open class ListConverter<T>(private val listType: Class<T>) {

    val moshi = NetworkModule.moshi

    @TypeConverter
    fun fromString(value: String?): List<T>? = value?.let {
        val listType = Types.newParameterizedType(List::class.java, listType)
        val adapter: JsonAdapter<List<T>> = moshi.adapter(listType)
        adapter.fromJson(it)
    }

    @TypeConverter
    fun fromClass(list: List<T>?): String? = list?.let {
        val listType = Types.newParameterizedType(List::class.java, listType)
        val adapter: JsonAdapter<List<T>> = moshi.adapter(listType)
        adapter.toJson(it)
    }
}

//class EquipmentListConverter : ListConverter<Equipment>(Equipment::class.java)
class LongListConverter : ListConverter<Long>(Long::class.javaObjectType)
