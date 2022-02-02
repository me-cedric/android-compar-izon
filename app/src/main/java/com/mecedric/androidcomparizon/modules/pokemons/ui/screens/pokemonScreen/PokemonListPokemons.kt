package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.pokemonScreen

import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.main.util.ListenRefresh
import com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.PokemonNav
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents
import com.mecedric.androidcomparizon.util.LocalBaseViewModel
import com.mecedric.androidcomparizon.util.SwipeRefreshList

@Composable
fun PokemonListPokemons(
    items: LazyPagingItems<Pokemon>,
    onEvent: (PokemonsEvents) -> Unit = {},
) {

    LocalBaseViewModel.current.ListenRefresh {
        if (it == PokemonNav.MainNav.pokemonsScreen.route) items.refresh()
    }

    SwipeRefreshList(
        items = items,
        state = rememberSwipeRefreshState(items.loadState.refresh is LoadState.Loading),
    ) { _, model ->
        PokemonsListPokemonsItems(
            model = model,
            onEvent = onEvent
        )
    }
}