package com.mecedric.androidcomparizon.modules.home.navigation.actions.impl

import androidx.navigation.NavHostController
import com.mecedric.androidcomparizon.modules.home.navigation.nav.HomeNav

interface HomeScreenActions {

    val controller: NavHostController

    fun navigateToHome() {
        controller.navigate(HomeNav.MainNav.HomeScreen.route)
    }
}