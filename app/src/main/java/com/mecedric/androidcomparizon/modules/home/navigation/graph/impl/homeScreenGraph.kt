package com.mecedric.androidcomparizon.modules.home.navigation.graph.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mecedric.androidcomparizon.modules.home.navigation.nav.impl.HomeNavScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mecedric.androidcomparizon.modules.home.ui.events.HomeEvents
import com.mecedric.androidcomparizon.modules.home.ui.screens.HomeScreen
import com.mecedric.androidcomparizon.modules.home.ui.viewModels.HomeViewModel
import com.mecedric.androidcomparizon.nav.NavActions

@ExperimentalComposeUiApi
fun NavGraphBuilder.homeScreenGraph(
    navActions: NavActions,
) {
    composable(HomeNavScreen.HomeScreen.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(viewModel = viewModel) { event ->
            when (event) {
                is HomeEvents.RefreshFeed -> viewModel.fetchPokemons()
                is HomeEvents.NavigateBack -> navActions.navigateToUp.invoke()
            }
        }
    }
}