package com.mecedric.androidcomparizon.api.clientImpl

import com.mecedric.androidcomparizon.api.ApiService
import com.mecedric.androidcomparizon.util.BaseDataSource

interface ApiServicePatch : BaseDataSource {
    val api: ApiService
}