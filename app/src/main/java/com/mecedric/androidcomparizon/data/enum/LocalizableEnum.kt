package com.mecedric.androidcomparizon.data.enum

import android.content.res.Resources

/**
 * Enum with translatable values and other options
 *
 * enum class Unit(val unit: String) : LocalizableEnum {
 *   KG("KG") { // Kilogram
 *     override fun toLocaleString(res: Resources) = getLocaleString(res, R.string.kg)
 *   };
 *   companion object {
 *     fun from(res: Resources, s: String): Unit? =
 *       values().find { it.unit == s || it.toLocaleString(res) == s }
 *   }
 * }
 */
interface LocalizableEnum {
    fun toLocaleString(res: Resources): String?
    fun getLocaleString(res: Resources, resId: Int): String? = res.getString(resId)
}
