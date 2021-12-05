package com.composeplayground.mvi_core.util

typealias DiffStrategy<T> = (T, T) -> Boolean

inline fun <T> byValue(): DiffStrategy<T> = { p1, p2 -> p1 != p2 }
inline fun <T> byRef(): DiffStrategy<T> = { p1, p2 -> p1 !== p2 }