package com.mecedric.androidcomparizon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mecedric.androidcomparizon.modules.home.navigation.nav.HomeNav
import com.mecedric.androidcomparizon.preferences.AppPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: AppPreferences,
) : ViewModel() {


    private val _toggleRefresh: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val toggleRefresh: StateFlow<Boolean> get() = _toggleRefresh.asStateFlow()

    private val _isReady: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isReady: StateFlow<Boolean> get() = _isReady.asStateFlow()

    private val _showSnackBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showSnackBar: StateFlow<Boolean> get() = _showSnackBar.asStateFlow()

    private val _route: MutableStateFlow<String> = MutableStateFlow("")
    val route: StateFlow<String> get() = _route.asStateFlow()

    init {
        viewModelScope.launch {
            // Hold a little splash
            delay(500)

            // Start app
            _isReady.value = true
        }
    }

    fun toggleSnackBar() {
        _showSnackBar.value = true
        viewModelScope.launch {
            delay(1500) // Loading second click
            _showSnackBar.value = false
        }
    }

    fun listRefresh() {
        _toggleRefresh.value = true
        viewModelScope.launch {
            delay(1000)
            _toggleRefresh.value = false
        }
    }

    fun setCurrentRoute(route: String) {
        if (route != _route.value) {
            // update data
            _route.value = route
        }
    }

    fun getStartRoute(): String {
//        return if (preferences.isStartPage) {
//            OtherNav.OnboardingNav.OnboardingScreen.route
//        } else {
        return HomeNav.MainNav.HomeScreen.route
//        }
    }

    fun startPageCompleted() {
        preferences.isStartPage = false
    }
}