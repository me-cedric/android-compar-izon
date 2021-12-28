package com.mecedric.androidcomparizon.modules.pokemons.services.api.impl

import androidx.annotation.IntRange
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.data.model.response.PokemonResponse
import com.mecedric.androidcomparizon.util.ConstantsPaging
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGet {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int?,
        @IntRange(from = 1, to = ConstantsPaging.MAX_PAGE_SIZE.toLong())
        @Query("limit") limit: Int = ConstantsPaging.PER_PAGE,
    ): Response<PokemonResponse>
}


