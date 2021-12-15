package com.mecedric.androidcomparizon.api.serviceImpl

import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.data.model.response.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGet {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon")
    suspend fun getPokemons(@Query("limit") limit: Int?, @Query("offset") offset: Int?): Response<PokemonResponse>
}