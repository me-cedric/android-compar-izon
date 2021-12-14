package com.mecedric.androidcomparizon.modules.home.services.apiService

import com.mecedric.androidcomparizon.modules.home.services.api.ApiHome
import com.mecedric.androidcomparizon.modules.home.services.apiService.impl.*
import javax.inject.Inject

class ApiServiceHome @Inject constructor(
    override val api: ApiHome,
) : ApiServiceDelete, ApiServiceGet, ApiServicePatch, ApiServicePost, ApiServicePut