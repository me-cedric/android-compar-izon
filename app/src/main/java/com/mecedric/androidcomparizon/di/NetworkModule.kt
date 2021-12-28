package com.mecedric.androidcomparizon.di

import com.mecedric.androidcomparizon.data.converter.InstantConverter
import com.mecedric.androidcomparizon.util.ConstantsApp
import com.mecedric.androidcomparizon.util.SerializeNulls.Companion.JSON_ADAPTER_FACTORY
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(BASIC))
        .build()

    val moshi: Moshi = Moshi.Builder()
        .add(JSON_ADAPTER_FACTORY)
        .add(InstantConverter())
//        .add(EnumAdapters())
        .build()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = moshi

    @Provides
    @Singleton
    fun providesRetrofitInstance(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ConstantsApp.API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()
}