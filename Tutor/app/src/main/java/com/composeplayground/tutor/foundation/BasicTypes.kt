package com.composeplayground.tutor.foundation

typealias ValueChange<T> = (T) -> Unit

typealias VoidCallback = ValueChange<Void>

typealias ValueChangeAsync<T> = suspend (T) -> Unit

typealias VoidCallbackAsync = ValueChangeAsync<Void>