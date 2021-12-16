package com.composeplayground.mvi_core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

interface IFeatureBloc<WishType : Wish, UiStateType : UiState> {
    val uiState: StateFlow<UiStateType>
    fun postWish(wish: WishType)
}

abstract class FeatureBloc<WishType : Wish, UiStateType : UiState>(initialUiState: UiStateType) :
    ViewModel(),
    IFeatureBloc<WishType, UiStateType> {
    private val _uiState = MutableStateFlow(initialUiState)
    var previousState: UiStateType = initialUiState
        private set
    override val uiState: StateFlow<UiStateType> = _uiState.asStateFlow()
    abstract override fun postWish(wish: WishType)
    protected fun postUiState(
        newUiState: UiStateType,
    ) {
        previousState = _uiState.getAndUpdate { newUiState } // update new state and return prior state
    }

    protected fun <T> startCollectingFlow(flow: Flow<T>, block: suspend (T) -> Unit) {
        executeAsyncTask {
            flow.collect(block)
        }
    }

    protected fun executeAsyncTask(block: suspend () -> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                block()
            }.onFailure {
                Log.e(this::class.simpleName, "executeTask: ${it.message}")
            }
        }
    }
}