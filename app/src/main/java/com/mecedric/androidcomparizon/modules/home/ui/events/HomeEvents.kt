package com.mecedric.androidcomparizon.modules.home.ui.events

sealed class HomeEvents {
    object RefreshFeed : HomeEvents()
    object NavigateBack : HomeEvents()
}