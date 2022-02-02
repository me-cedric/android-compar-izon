package com.mecedric.androidcomparizon.modules.pokemons.navigation.graph.impl

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.PokemonNav
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents
import com.mecedric.androidcomparizon.modules.pokemons.ui.screens.pokemonScreen.PokemonsScreen
import com.mecedric.androidcomparizon.modules.pokemons.ui.viewModels.PokemonsViewModel
import com.mecedric.androidcomparizon.nav.NavActions

@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.detailsScreenGraph(
    navActions: NavActions,
) {
    composable(PokemonNav.MainNav.detailsScreen.route) {
        val viewModel: PokemonsViewModel = hiltViewModel()
        PokemonsScreen(viewModel = viewModel) { event ->
            when (event) {
                is PokemonsEvents.NavigateBack -> navActions.navigateToUp.invoke()
            }
        }
    }
}