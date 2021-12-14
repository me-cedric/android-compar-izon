package com.mecedric.androidcomparizon.modules.home.navigation.graph

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraphBuilder
import com.mecedric.androidcomparizon.modules.home.navigation.graph.impl.homeScreenGraph
import com.mecedric.androidcomparizon.util.NavActions

@ExperimentalComposeUiApi
@Suppress("UNUSED_PARAMETER")
fun NavGraphBuilder.homeNavGraph(
    navActions: NavActions,
) {
    homeScreenGraph()
}