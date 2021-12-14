package com.mecedric.androidcomparizon.preferences

import android.content.SharedPreferences

interface AppPreferencesListCache {

    val p: SharedPreferences

    enum class KEYS {
        LAST_UPDATE_FEED,
        LAST_UPDATE_LIST_FAVORITE,
        LAST_UPDATE_LIST_BRANDS,
        LAST_UPDATE_LIST_CATEGORIES,
    }

    fun clearAfterLogout() {
        lastUpdateListFavorite = 0L
    }

    var lastUpdateFeed: Long
        get() = p.getLong(KEYS.LAST_UPDATE_FEED.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_FEED.name, value).apply()

    var lastUpdateListFavorite: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_FAVORITE.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_FAVORITE.name, value).apply()

    var lastUpdateListBrands: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_BRANDS.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_BRANDS.name, value).apply()

    var lastUpdateListCategories: Long
        get() = p.getLong(KEYS.LAST_UPDATE_LIST_CATEGORIES.name, 0L)
        set(value) = p.edit().putLong(KEYS.LAST_UPDATE_LIST_CATEGORIES.name, value).apply()
}