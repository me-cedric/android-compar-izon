package com.mecedric.androidcomparizon.util

object GlobalNavigator {

    private var handler: GlobalNavigationHandler? = null

    fun registerHandler(handler: GlobalNavigationHandler) {
        GlobalNavigator.handler = handler
    }

    fun unregisterHandler() {
        handler = null
    }

    fun logout() {
        handler?.logout()
    }
}

interface GlobalNavigationHandler {
    fun logout()
}