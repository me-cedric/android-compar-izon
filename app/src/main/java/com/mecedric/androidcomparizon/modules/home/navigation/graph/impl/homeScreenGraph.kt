package com.mecedric.androidcomparizon.modules.home.navigation.graph.impl

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mecedric.androidcomparizon.modules.home.navigation.nav.impl.HomeNavScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.mecedric.androidcomparizon.modules.home.ui.events.HomeEvents
import com.mecedric.androidcomparizon.modules.home.ui.screens.HomeScreen
import com.mecedric.androidcomparizon.modules.home.ui.viewModels.HomeViewModel

@ExperimentalComposeUiApi
fun NavGraphBuilder.homeScreenGraph() {
    composable(HomeNavScreen.HomeScreen.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(viewModel = viewModel) { event ->
            when (event) {
                is HomeEvents.RefreshFeed -> viewModel.fetchPokemons()
            }
        }
    }
}