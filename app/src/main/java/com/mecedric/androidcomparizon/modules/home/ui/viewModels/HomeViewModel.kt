package com.mecedric.androidcomparizon.modules.home.ui.viewModels

import androidx.lifecycle.*
import com.mecedric.androidcomparizon.data.model.Pokemon
import com.mecedric.androidcomparizon.data.repository.PokemonRepository
import com.mecedric.androidcomparizon.preferences.AppPreferences
import com.mecedric.androidcomparizon.util.CallResult.Status.*
import com.mecedric.androidcomparizon.util.ConstantsPaging
import com.mecedric.androidcomparizon.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val sharedPreferences: AppPreferences
) : ViewModel() {
    private val limit: Int = 20
    private var offset: Int = 0

    private val _commonError: MutableLiveData<String?> = MutableLiveData(null)
    val commonError: LiveData<String?> get() = _commonError

    private val _loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    private val _onPokemonFetchedEvent = MutableLiveData<Event<Unit>>()
    val onPokemonFetched: LiveData<Event<Unit>> = _onPokemonFetchedEvent

    private var pokemonFetchingLiveData: MutableLiveData<Event<Unit>> = MutableLiveData()

    init {
        if (System.currentTimeMillis() - sharedPreferences.lastUpdateFeed >= ConstantsPaging.CACHE_TIMEOUT) {
            fetchPokemons()
        }
    }

    fun fetchPokemons() {
        offset = 0
        sharedPreferences.lastUpdateFeed = System.currentTimeMillis()
        // start update
        _commonError.postValue(null)
        // make a request
        loadPokemons()
    }

    val pokemonsLiveData: LiveData<List<Pokemon>?> = pokemonFetchingLiveData.switchMap {
        pokemonRepository.observePokemonList(limit, offset).map { result ->
            when (result.status) {
                SUCCESS -> {
                    _onPokemonFetchedEvent.postValue(Event(Unit))
                }
                ERROR -> {
                    _commonError.postValue("Error update feed")
                }
                LOADING -> _loading.postValue(true)
                DONE -> {
                    _loading.postValue(false)
                }
            }
            result.data
        }
    }

    fun loadPokemons() {
        pokemonFetchingLiveData.postValue(Event(Unit))
    }

    fun loadMorePokemons() {
        offset += limit
        loadPokemons()
    }
}
