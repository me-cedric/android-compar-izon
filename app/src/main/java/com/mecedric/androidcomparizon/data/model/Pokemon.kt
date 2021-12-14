package com.mecedric.androidcomparizon.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
@JsonClass(generateAdapter = true)
data class Pokemon(
    @field:Json(name = "id") @PrimaryKey var id: Int? = 0,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") var url: String
) : Parcelable