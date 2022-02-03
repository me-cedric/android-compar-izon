package com.mecedric.androidcomparizon.modules.pokemons.ui.screens.detailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.DetailsEvents

@ExperimentalPagerApi
@ExperimentalComposeUiApi
@Composable
fun DetailsBody(
    listDetails: LazyPagingItems<Pokemon>,
    onEvent: (DetailsEvents) -> Unit = {},
) {

    val scope = rememberCoroutineScope()

    Scaffold {
        Column {
        }
    }
}
