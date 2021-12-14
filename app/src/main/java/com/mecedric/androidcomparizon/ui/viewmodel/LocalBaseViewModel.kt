package com.mecedric.androidcomparizon.ui.viewmodel

import androidx.compose.runtime.staticCompositionLocalOf

val LocalBaseViewModel = staticCompositionLocalOf<MainViewModel> { error("No MainViewModel found!") }