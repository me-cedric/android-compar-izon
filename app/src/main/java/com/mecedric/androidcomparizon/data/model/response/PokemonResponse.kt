package com.mecedric.androidcomparizon.data.model.response

import com.mecedric.androidcomparizon.data.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PokemonResponse(
    @field:Json(name = "count") val count: Long? = 0,
    @field:Json(name = "results") val results: List<Pokemon> = listOf(),
)