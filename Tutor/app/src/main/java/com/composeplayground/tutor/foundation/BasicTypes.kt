package com.composeplayground.tutor.foundation

typealias ValueChange<T> = (T) -> Unit

typealias VoidCallback = () -> Unit

typealias ValueChangeAsync<T> = suspend (T) -> Unit

typealias VoidCallbackAsync = suspend () -> Unit