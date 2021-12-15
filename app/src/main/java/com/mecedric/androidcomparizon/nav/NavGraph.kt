package com.mecedric.androidcomparizon.util

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
import com.google.accompanist.insets.ProvideWindowInsets
import com.mecedric.androidcomparizon.modules.compose.BottomBar
import com.mecedric.androidcomparizon.modules.home.navigation.graph.homeNavGraph
import com.mecedric.androidcomparizon.modules.home.navigation.nav.HomeNav
import com.mecedric.androidcomparizon.nav.NavActions
import com.mecedric.androidcomparizon.modules.main.viewmodel.MainViewModel
import com.mecedric.androidcomparizon.nav.HomeTab.Companion.findByRoute

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavGraph(navController: NavHostController, viewModel: MainViewModel) {

    navController.AddChangeRouteListener()

    val navActions = remember(navController) {
        NavActions(navController)
    }

    ProvideWindowInsets {

        val scaffoldState = rememberScaffoldState()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: HomeNav.MainNav.HomeScreen.route

        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = currentRoute.findByRoute()?.let { homeTab ->
                {
                    BottomBar(
                        currentRoute = homeTab,
                        navActions = navActions
                    )
                }
            } ?: run { {} },
        ) {
            Box(
                modifier = Modifier.padding(it)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = viewModel.getStartRoute()
                ) {
                    homeNavGraph(
                        navActions = navActions
                    )
                }
            }
        }
    }
}