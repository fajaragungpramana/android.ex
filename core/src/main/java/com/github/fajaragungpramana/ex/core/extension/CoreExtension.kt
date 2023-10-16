package com.github.fajaragungpramana.ex.core.extension

fun String?.onEmpty() =  this ?: ""

@Suppress("UNCHECKED_CAST")
inline fun <reified T> Map<String, T?>.removeNulls(): Map<String, T> {
    return filterValues { it != null } as Map<String, T>
}