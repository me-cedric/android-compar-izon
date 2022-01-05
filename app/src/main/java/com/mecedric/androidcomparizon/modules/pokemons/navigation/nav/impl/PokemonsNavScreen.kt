package com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.impl

import com.mecedric.androidcomparizon.util.NavScreen

object PokemonsNavScreen {
    val pokemonsScreen = object : NavScreen {
        override val route: String = "PokemonsScreen"
    }
    val detailsScreen = object : NavScreen {
        override val route: String = "DetailsScreen"
    }
}