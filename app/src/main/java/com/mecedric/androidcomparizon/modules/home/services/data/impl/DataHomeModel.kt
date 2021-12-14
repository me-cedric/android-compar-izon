package com.mecedric.androidcomparizon.modules.home.services.data.impl

import com.mecedric.androidcomparizon.persistence.AppDatabase
import com.mecedric.androidcomparizon.preferences.AppPreferences

interface DataHomeModel {
    val db: AppDatabase
    val preferences: AppPreferences
}