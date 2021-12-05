package com.composeplayground.tutor.presentation

import com.composeplayground.mvi_core.UiState
import com.composeplayground.tutor.domain.entities.UiError

interface TutorUiState<T> : UiState {
    val data: T
    val isLoading: Boolean
    val error: UiError?
}