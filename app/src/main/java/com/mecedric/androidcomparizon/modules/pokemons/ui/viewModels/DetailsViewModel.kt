package com.mecedric.androidcomparizon.modules.pokemons.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.paging.PokemonsRemoteMediator
import com.mecedric.androidcomparizon.modules.pokemons.services.apiService.ApiServicePokemon
import com.mecedric.androidcomparizon.modules.pokemons.services.data.DataServicePokemon
import com.mecedric.androidcomparizon.util.ConstantsPaging
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val data: DataServicePokemon,
    apiService: ApiServicePokemon,
) : ViewModel() {

    private val _errorConnection: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorConnection: StateFlow<Boolean> get() = _errorConnection.asStateFlow()

    @ExperimentalPagingApi
    val listPokemons: Flow<PagingData<Pokemon>> = Pager(
        config = PagingConfig(pageSize = ConstantsPaging.PER_PAGE),
        remoteMediator = PokemonsRemoteMediator(data, apiService) { status ->
            _errorConnection.value = status
        }
    ) {
        data.pagingListPokemonModel()
    }.flow

}
