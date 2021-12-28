package com.mecedric.androidcomparizon.nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.paging.ExperimentalPagingApi
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mecedric.androidcomparizon.modules.main.viewmodel.MainViewModel
import com.mecedric.androidcomparizon.modules.pokemons.navigation.actions.PokemonsNavActions
import com.mecedric.androidcomparizon.modules.pokemons.navigation.graph.pokemonsNavGraph
import com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.PokemonNav
import com.mecedric.androidcomparizon.util.AddChangeRouteListener

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@ExperimentalPagingApi
@Composable
fun NavGraph(navController: NavHostController, viewModel: MainViewModel) {

    navController.AddChangeRouteListener()

    val navActions = remember(navController) {
        NavActions(navController)
    }

    ProvideWindowInsets {

        val scaffoldState = rememberScaffoldState()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: PokemonNav.MainNav.pokemonsScreen.route

        Scaffold(
            scaffoldState = scaffoldState
        ) {
            Box(
                modifier = Modifier.padding(it)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = viewModel.getStartRoute()
                ) {
                    pokemonsNavGraph(
                        navActions = navActions
                    )
                }
            }
        }
    }
}