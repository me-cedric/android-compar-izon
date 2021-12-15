package com.mecedric.androidcomparizon.modules.main.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.mecedric.androidcomparizon.modules.main.viewmodel.MainViewModel

// Update after the second click on the active bottom navigator
@Composable
fun MainViewModel.ListenRefresh(listener: (route: String) -> Unit) {
    val refresh by toggleRefresh.collectAsState()
    LaunchedEffect(refresh) {
        if (refresh) {
            listener.invoke(route.value)
        }
    }
}