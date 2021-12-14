package com.mecedric.androidcomparizon.preferences

import android.content.SharedPreferences

interface AppPreferencesBase {

    val p: SharedPreferences

    enum class KEYS {
        ACCESS_TOKEN,
        REFRESH_TOKEN,
        IS_START_PAGE,
    }

    fun isLogin(): Boolean {
        return _accessToken.isNotEmpty()
    }

    fun clearAfterLogout() {
        _accessToken = ""
        _refreshToken = ""
    }

    val accessToken: String get() = _accessToken
    private var _accessToken: String
        get() = p.getString(KEYS.ACCESS_TOKEN.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.ACCESS_TOKEN.name, value).apply()


    val refreshToken: String get() = _refreshToken
    private var _refreshToken: String
        get() = p.getString(KEYS.REFRESH_TOKEN.name, null) ?: ""
        set(value) = p.edit().putString(KEYS.REFRESH_TOKEN.name, value).apply()


    fun setTokens(accessToken: String, refreshToken: String) {
        _accessToken = accessToken
        _refreshToken = refreshToken
    }

    var isStartPage: Boolean
        get() = p.getBoolean(KEYS.IS_START_PAGE.name, true)
        set(value) = p.edit().putBoolean(KEYS.IS_START_PAGE.name, value).apply()
}