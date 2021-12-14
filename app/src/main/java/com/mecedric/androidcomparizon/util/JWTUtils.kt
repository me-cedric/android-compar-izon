package com.mecedric.androidcomparizon.util

import android.util.Base64
import com.mecedric.androidcomparizon.di.NetworkModule.moshi
import java.io.UnsupportedEncodingException


object JWTUtils {

    @Throws(Exception::class)
    inline fun <reified T> decoded(JWTEncoded: String): T? {
        val split = JWTEncoded.trim().split(".")
        val mAdapt = moshi.adapter(T::class.java)
        return mAdapt.fromJson(getJson(split[1]))
    }

    @Throws(UnsupportedEncodingException::class)
    fun getJson(strEncoded: String): String {
        val decodedBytes: ByteArray = Base64.decode(strEncoded, Base64.URL_SAFE)
        return String(decodedBytes, charset("UTF-8"))
    }
}