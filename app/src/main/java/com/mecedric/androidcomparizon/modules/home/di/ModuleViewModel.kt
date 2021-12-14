package com.mecedric.androidcomparizon.modules.home.di

import com.mecedric.androidcomparizon.modules.home.services.api.ApiHome
import com.mecedric.androidcomparizon.modules.home.services.apiService.ApiServiceHome
import com.mecedric.androidcomparizon.modules.home.services.data.DataServiceHome
import com.mecedric.androidcomparizon.persistence.AppDatabase
import com.mecedric.androidcomparizon.preferences.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ModuleViewModel {

    @Provides
    fun provideDataServiceCart(db: AppDatabase, preferences: AppPreferences) =
        DataServiceHome(db, preferences)

    @Provides
    fun provideApiServiceCart(api: ApiHome) = ApiServiceHome(api)
}
