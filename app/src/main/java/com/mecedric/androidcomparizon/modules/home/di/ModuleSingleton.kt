package com.mecedric.androidcomparizon.modules.home.di

import com.mecedric.androidcomparizon.modules.home.services.api.ApiHome
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ModuleSingleton {

    @Provides
    fun provideApiHome(retrofit: Retrofit) = retrofit.create(ApiHome::class.java)
}
