package com.mecedric.androidcomparizon.util

import androidx.navigation.NavHostController
import com.mecedric.androidcomparizon.modules.home.navigation.actions.HomeNavActions

class NavActions(
    override val controller: NavHostController,
) : HomeNavActions {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }
}