package com.mecedric.androidcomparizon.api

import com.mecedric.androidcomparizon.api.clientImpl.*
import javax.inject.Inject

class ApiClient @Inject constructor(
    override val api: ApiService,
) : ApiServiceDelete, ApiServiceGet, ApiServicePatch, ApiServicePost, ApiServicePut