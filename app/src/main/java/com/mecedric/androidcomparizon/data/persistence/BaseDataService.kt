package com.mecedric.androidcomparizon.data.persistence

import androidx.room.withTransaction
import com.mecedric.androidcomparizon.preferences.AppPreferences

interface BaseDataService<T : Any> {

    val db: AppDatabase
    val preferences: AppPreferences

    @Suppress("UNCHECKED_CAST")
    suspend fun withTransaction(body: suspend T.() -> Unit) {
        db.withTransaction {
            body.invoke(this as T)
        }
    }
}