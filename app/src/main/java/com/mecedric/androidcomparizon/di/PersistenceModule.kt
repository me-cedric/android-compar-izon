package com.mecedric.androidcomparizon.di

import android.content.Context
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.mecedric.androidcomparizon.data.persistence.AppDatabase
import com.mecedric.androidcomparizon.preferences.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): AppPreferences {
        return AppPreferences(
            EncryptedSharedPreferences.create(
                context,
                "sharedPrefsFile",
                MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        )
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext application: Context): AppDatabase = Room
            .databaseBuilder(application, AppDatabase::class.java, "poke.db")
            .fallbackToDestructiveMigration()
            .build()
}