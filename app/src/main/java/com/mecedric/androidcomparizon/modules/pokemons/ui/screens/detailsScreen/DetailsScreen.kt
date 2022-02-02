package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.detailsScreen

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
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.DetailsEvents
import com.mecedric.androidcomparizon.modules.pokemons.ui.viewModels.DetailsViewModel

@ExperimentalPagingApi
@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    onEvent: (DetailsEvents) -> Unit = {},
) {

    val listDetails: LazyPagingItems<Pokemon> = viewModel.listPokemons.collectAsLazyPagingItems()

    DetailsBody(
        onEvent = onEvent,
        listDetails = listDetails
    )

    if (viewModel.errorConnection.collectAsState().value) {
        ErrorNetworkScreen(
            listDetails.loadState.refresh is LoadState.Loading
        )
    }
}
