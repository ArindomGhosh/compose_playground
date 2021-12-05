package com.composeplayground.mvi_core

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composeplayground.mvi_core.util.DiffStrategy
import com.composeplayground.mvi_core.util.byValue
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
        diffStrategy: DiffStrategy<UiStateType> = byValue()
    ) {
        if (!diffStrategy(previousState, _uiState.value)) {
            previousState = if (!diffStrategy(previousState, _uiState.value)) _uiState.value else previousState
            _uiState.value = newUiState
        }
    }

    protected fun <T> startCollectingFlow(flow: Flow<T>, block: suspend (T) -> Unit) {
        executeTask {
            flow.collect(block)
        }
    }

    private fun executeTask(block: suspend () -> Unit) {
        viewModelScope.launch {
            kotlin.runCatching {
                block()
            }.onFailure {
                Log.e(this::class.simpleName, "executeTask: ${it.message}")
            }
        }
    }
}