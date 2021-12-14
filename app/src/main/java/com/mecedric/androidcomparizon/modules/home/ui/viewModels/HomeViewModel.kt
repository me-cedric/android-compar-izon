package com.mecedric.androidcomparizon.modules.home.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mecedric.androidcomparizon.modules.home.services.apiService.ApiServiceHome
import com.mecedric.androidcomparizon.modules.home.services.data.DataServiceHome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val data: DataServiceHome,
    private val apiService: ApiServiceHome,
) : ViewModel() {

    private val _errorConnection: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val errorConnection: StateFlow<Boolean> get() = _errorConnection.asStateFlow()

    private val _commonError: MutableStateFlow<String?> = MutableStateFlow(null)
    val commonError: StateFlow<String?> get() = _commonError.asStateFlow()

    private val _loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading.asStateFlow()

    init {
        if (System.currentTimeMillis() - data.preferences.lastUpdateFeed >= ConstantsPaging.CACHE_TIMEOUT) {
            updateFeed()
        }
    }

    fun updateFeed() {
        data.preferences.lastUpdateFeed = System.currentTimeMillis()
        // start update
        _commonError.value = null
        _loading.value = true
        // make a request
        viewModelScope.launch {
            apiService.getFeed()
                .success { response ->
                    // clear old data
                    data.clear()
                    // insert if not null
                    response?.let {
                        data.insert(it)
                    }
                }
                .error {
                    Timber.e(it)
                    crashlytics.recordException(it)
                    _commonError.value = it.message ?: "Error update feed"
                }
                .done {
                    delay(500) // disable loading after insert
                    _loading.value = false
                    _errorConnection.value = false
                }
                .errorUnknownHost {
                    _errorConnection.value = true
                }
        }
    }

    fun getFeed(): Flow<FeedRelation?> {
        return data.getFeedRelation().distinctUntilChanged()
    }

}
