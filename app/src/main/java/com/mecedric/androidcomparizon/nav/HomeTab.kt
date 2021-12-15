package com.mecedric.androidcomparizon.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.mecedric.androidcomparizon.modules.home.navigation.nav.HomeNav

enum class HomeTab(
    val route: String,
    val icon: ImageVector,
) {

    HOME(HomeNav.MainNav.HomeScreen.route, Icons.Filled.Dashboard);

    companion object {
        fun String.findByRoute(): HomeTab? {
            return when (this) {
                HOME.route -> HOME
                else -> null
            }
        }
    }
}