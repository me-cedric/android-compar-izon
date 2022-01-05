package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.pokemonScreen

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents

@Composable
fun PokemonListPokemons(
    items: LazyPagingItems<Pokemon>,
    onEvent: (PokemonsEvents) -> Unit = {},
) {

//    LocalBaseViewModel.current.ListenRefresh {
//        if (it == PokemonNav.MainNav.pokemonsScreen.route) items.refresh()
//    }

//    SwipeRefreshList(
//        modifier = Modifier,
//        items = items,
//        state = rememberSwipeRefreshState(items.loadState.refresh is LoadState.Loading),
//        contentEmpty = {
////            PlugBlock(
////                title = stringResource(id = R.string.common_state_empty_title),
////                text = stringResource(id = R.string.pokemons_state_empty_text_brands),
////            )
//        },
//        contentLoadState = {
//            if (it is LoadState.Loading) {
//                Loader(Modifier.paddingLarge())
//            }
//        }
//    ) { _, model ->
//        PokemonsListPokemonsItems(
//            model = model
//        )
//    }
}