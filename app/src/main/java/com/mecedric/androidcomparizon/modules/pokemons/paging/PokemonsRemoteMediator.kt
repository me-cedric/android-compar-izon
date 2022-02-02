package com.mecedric.androidcomparizon.modules.pokemons.paging

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.ApiServicePokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.data.DataServicePokemon
import com.mecedric.androidcomparizon.util.CallResult.Status.*
import com.mecedric.androidcomparizon.util.ConstantsPaging.CACHE_TIMEOUT
import kotlin.math.roundToInt

@ExperimentalPagingApi
class PokemonsRemoteMediator(
    private val data: DataServicePokemon,
    private val apiService: ApiServicePokemon,
    private val onErrorUnknownHost: (Boolean) -> Unit,
) : RemoteMediator<Int, Pokemon>() {

    override suspend fun initialize(): InitializeAction {
        return if (System.currentTimeMillis() - data.preferences.lastUpdateListBrands >= CACHE_TIMEOUT) {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        } else {
            InitializeAction.SKIP_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Pokemon>,
    ): MediatorResult {
        return try {

            val page = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> (data.countPokemonModel() / state.config.pageSize.toFloat())
                    .roundToInt()
                    .plus(1)
            }

            val response = apiService.getListPokemons(
                page = page ?: 0
            )

            when(response.status) {
                SUCCESS ->
                    data.withTransaction {
                        if (loadType == LoadType.REFRESH) {
                            preferences.lastUpdateListBrands = System.currentTimeMillis()
                            clearPokemonModel()
                        }
                        if (response.data?.results != null || loadType != LoadType.APPEND) {
                            insertPokemonModel(response.data?.results!!)
                        }
                    }
                ERROR -> Log.e("pokemon", response.message ?: "error loading pokemons")
                DONE -> onErrorUnknownHost.invoke(false)
                else -> {}
            }

            MediatorResult.Success(
                endOfPaginationReached = true
            )

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}