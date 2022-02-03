package com.mecedric.androidcomparizon.modules.pokemons.navigation.actions.impl

import androidx.navigation.NavHostController
import com.mecedric.androidcomparizon.modules.pokemons.navigation.nav.PokemonNav

interface PokemonsScreenActions {

    val controller: NavHostController

    fun navigateToPokemonListPage() {
        controller.navigate(PokemonNav.MainNav.pokemonsScreen.route)
    }

    fun navigateToDetailsPage(id: Int) {
        controller.navigate(PokemonNav.MainNav.detailsScreen.route)
    }
}