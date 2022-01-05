package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.pokemonScreen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.compose.ErrorNetworkScreen
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents
import com.mecedric.androidcomparizon.modules.pokemons.ui.viewModels.PokemonsViewModel

@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun PokemonsScreen(
    viewModel: PokemonsViewModel,
    onEvent: (PokemonsEvents) -> Unit = {},
) {

    val listPokemons: LazyPagingItems<Pokemon> = viewModel.listPokemons.collectAsLazyPagingItems()

    PokemonsBody(
        onEvent = onEvent,
        listPokemons = listPokemons
    )

    if (viewModel.errorConnection.collectAsState().value) {
        ErrorNetworkScreen(
            listPokemons.loadState.refresh is LoadState.Loading
        )
    }
}
