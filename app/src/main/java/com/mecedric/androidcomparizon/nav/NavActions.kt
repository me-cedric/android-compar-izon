package com.mecedric.androidcomparizon.nav

import androidx.navigation.NavHostController
import com.mecedric.androidcomparizon.modules.pokemons.navigation.actions.PokemonsNavActions

class NavActions(
    override val controller: NavHostController,
) : PokemonsNavActions {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }
}