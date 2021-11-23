package com.composeplayground.tutor.presentation

import com.composeplayground.tutor.domain.entities.UiError

sealed interface TutorUiState<T> {
    val data: T
    val isLoading: Boolean
    val error: UiError
}