package com.mecedric.androidcomparizon.modules.pokemons.navigation.graph.impl

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.PokemonNav
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.DetailsEvents
import com.mecedric.androidcomparizon.modules.pokemons.ui.events.PokemonsEvents
import com.mecedric.androidcomparizon.modules.pokemons.ui.screens.detailsScreen.DetailsScreen
import com.mecedric.androidcomparizon.modules.pokemons.ui.screens.pokemonScreen.PokemonsScreen
import com.mecedric.androidcomparizon.modules.pokemons.ui.viewModels.DetailsViewModel
import com.mecedric.androidcomparizon.modules.pokemons.ui.viewModels.PokemonsViewModel
import com.mecedric.androidcomparizon.nav.NavActions

@ExperimentalMaterialApi
@ExperimentalPagingApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
fun NavGraphBuilder.detailsScreenGraph(
    navActions: NavActions,
) {
    composable(PokemonNav.MainNav.detailsScreen.route,
        arguments = listOf(navArgument("pokemonId") { type = NavType.StringType })
        ) {
        val viewModel: DetailsViewModel = hiltViewModel()
        DetailsScreen(viewModel = viewModel) { event ->
            when (event) {
                is DetailsEvents.NavigateBack -> navActions.navigateToUp.invoke()
            }
        }
    }
}