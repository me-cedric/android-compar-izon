package com.mecedric.androidcomparizon.di

import android.content.Context
import androidx.room.Room
import com.mecedric.androidcomparizon.persistence.AppDatabase
import com.mecedric.androidcomparizon.persistence.PokemonDao
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
    @Singleton
    fun provideAppDatabase(@ApplicationContext application: Context): AppDatabase = Room
            .databaseBuilder(application, AppDatabase::class.java, "poke.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideBookmarkDao(bookmarkDatabase: AppDatabase) : PokemonDao {
        return bookmarkDatabase.pokemonDao()
    }
}