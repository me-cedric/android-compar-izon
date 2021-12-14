package com.mecedric.androidcomparizon.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

const val TIMEZONE = "Europe/Paris"

/**
 * Convert an Instant date to the pattern d MMMM HH:mm
 */
fun Instant.toLocalDateTimeString(): String {
    val formatter: DateTimeFormatter = DateTimeFormatter
        .ofPattern("d MMMM HH:mm")
        .withZone(ZoneId.of(TIMEZONE))
    return formatter.format(this)
}

/**
 * Convert an Instant date to the pattern dd/MM/yyyy - HH:mm
 */
fun Instant.toLocalCalendarDateTimeString(): String {
    val formatter: DateTimeFormatter = DateTimeFormatter
        .ofPattern("dd/MM/yyyy - HH:mm")
        .withZone(ZoneId.of(TIMEZONE))
    return formatter.format(this)
}

/**
 * Convert an Instant date to the pattern dd/MM - HH:mm
 */
fun Instant.toDayMonthTimeString(): String {
    val formatter: DateTimeFormatter = DateTimeFormatter
        .ofPattern("dd/MM - HH:mm")
        .withZone(ZoneId.of(TIMEZONE))
    return formatter.format(this)
}

/**
 * Convert an Instant date to the pattern dd/MM/yyyy
 */
fun Instant.toLocalDateString(): String {
    val formatter: DateTimeFormatter = DateTimeFormatter
        .ofPattern("dd/MM/yyyy")
        .withZone(ZoneId.of(TIMEZONE))
    return formatter.format(this)
}