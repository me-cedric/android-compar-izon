package com.mecedric.androidcomparizon.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.PokemonNav

enum class Pages(
    val route: String,
    val icon: ImageVector,
) {

    HOME(PokemonNav.MainNav.pokemonsScreen.route, Icons.Filled.Dashboard),
    DETAIL(PokemonNav.MainNav.detailsScreen.route, Icons.Filled.Dashboard);

    companion object {
        fun String.findByRoute(): Pages? {
            return when (this) {
                HOME.route -> HOME
                else -> null
            }
        }
    }
}