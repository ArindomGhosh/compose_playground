package com.composeplayground.tutor.foundation

typealias valueChange<T> = (T) -> Unit

typealias voidCallback = valueChange<Void>

typealias valueChangeAsync<T> = suspend (T) -> Unit

typealias voidCallbackAsync = valueChangeAsync<Void>