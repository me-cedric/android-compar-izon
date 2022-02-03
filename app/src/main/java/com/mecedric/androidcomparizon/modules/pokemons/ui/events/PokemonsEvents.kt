package com.mecedric.androidcomparizon.modules.pokemons.ui.events

sealed class PokemonsEvents {
    object NavigateBack : PokemonsEvents()
    data class NavigateToDetails(val pokemonId: Int) : PokemonsEvents()
}