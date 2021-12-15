package com.mecedric.androidcomparizon.util

import java.util.concurrent.TimeUnit

object ConstantsPaging {

    // lists refresh once per hour
    val CACHE_TIMEOUT = TimeUnit.HOURS.toMillis(1)

    // const for api query
    const val MAX_PAGE_SIZE = 100
    const val PER_PAGE = 20
}