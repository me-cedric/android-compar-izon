package com.mecedric.androidcomparizon.modules.pokemons.services.apiService

import com.mecedric.androidcomparizon.modules.pokemons.services.api.ApiPokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.impl.*
import javax.inject.Inject

class ApiServicePokemon @Inject constructor(
    override val api: ApiPokemon,
) : ApiServiceDelete, ApiServiceGet, ApiServicePatch, ApiServicePost, ApiServicePut