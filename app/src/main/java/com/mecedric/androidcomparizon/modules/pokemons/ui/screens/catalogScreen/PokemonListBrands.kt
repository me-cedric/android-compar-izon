package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.catalogScreen

//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.paging.LoadState
//import androidx.paging.compose.LazyPagingItems
//import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
//import com.mecedric.androidcomparizon.R
//import com.mecedric.androidcomparizon.data.model.Pokemon
//import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents

//@Composable
//fun PokemonListPokemons(
//    items: LazyPagingItems<Pokemon>,
//    onEvent: (PokemonsEvents) -> Unit = {},
//) {
//
//    val error by LocalTryExecuteWithResponse.current.collectAsState(null)
//    LaunchedEffect(error) {
////        error?.let {
////            Timber.e("------------------- Common error listener")
////            Timber.e(it)
////            Timber.e("------------------- ")
////        }
//    }
//
//    LocalBaseViewModel.current.ListenRefresh {
//        if (it == CatalogNav.MainNav.pokemonsScreen.route) items.refresh()
//    }
//
//    SwipeRefreshList(
//        modifier = Modifier,
//        items = items,
//        state = rememberSwipeRefreshState(items.loadState.refresh is LoadState.Loading),
//        contentEmpty = {
//            PlugBlock(
//                title = stringResource(id = R.string.common_state_empty_title),
//                text = stringResource(id = R.string.pokemons_state_empty_text_brands),
//            )
//        },
//        contentLoadState = {
//            if (it is LoadState.Loading) {
//                Loader(Modifier.paddingLarge())
//            }
//        }
//    ) { _, model ->
//        PokemonsListPokemons(
//            model = model
//        )
//    }
//}