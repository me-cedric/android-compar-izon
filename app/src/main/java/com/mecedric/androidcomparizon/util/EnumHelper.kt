package com.mecedric.androidcomparizon.util

/**
 * Returns `true` if enum T contains an entry with the specified name.
 * @param name the name of the enum entry
 */
inline fun <reified T : Enum<T>> enumContains(name: String): Boolean {
    return enumValues<T>().any { it.name == name }
}

/**
 * Try returning the value of an enum from a nullable string
 * @param name the name of the enum entry
 */
inline fun <reified T : Enum<T>> safeEnumValueOf(name: String?): T? = name?.let {
    if (enumContains<T>(it)) {
        enumValueOf<T>(name)
    } else {
        null
    }
}