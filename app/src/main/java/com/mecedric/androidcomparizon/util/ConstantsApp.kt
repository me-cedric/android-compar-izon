package com.mecedric.androidcomparizon.util

import com.mecedric.androidcomparizon.BuildConfig

object ConstantsApp {
    const val REFRESH_DELAY = 60000L
    const val DEBUG_DELAY = 1000L

    val API_URL_BASE
        get() =
            if (BuildConfig.DEBUG)
                "https://pokeapi.co/"
            else
                "https://pokeapi.co/"

    val API_URL get() = "$API_URL_BASE/api/v2/"
}