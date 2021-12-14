package com.mecedric.androidcomparizon.modules.home.services.data

import com.mecedric.androidcomparizon.modules.home.services.data.impl.DataHomeModel
import com.mecedric.androidcomparizon.persistence.AppDatabase
import com.mecedric.androidcomparizon.persistence.BaseDataService
import com.mecedric.androidcomparizon.preferences.AppPreferences

class DataServiceHome(
    override val db: AppDatabase,
    override val preferences: AppPreferences,
) : BaseDataService<DataServiceHome>,
    DataHomeModel