package com.mecedric.androidcomparizon.modules.pokemons.navigation.graph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mecedric.androidcomparizon.modules.pokemons.navigation.graph.impl.pokemonsScreenGraph
import com.mecedric.androidcomparizon.nav.NavActions

@ExperimentalPagingApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.pokemonsNavGraph(
    navActions: NavActions,
) {
    pokemonsScreenGraph(navActions)
}