package com.composeplayground.tutor.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * ViewModel consumes the events generated from UI
 * and triggers the required UseCases
 * */
abstract class TutorBaseViewModel<UiState : TutorUiState<*>, UiEvent : TutorEvents> : ViewModel(),
        ITutorUiEventConsumer<UiEvent> by TutorUiEventConsumerImpl() {

    abstract val uiState: StateFlow<UiState>

    fun startCollectingUiEvents() {
        startCollectingFlow(events, ::handleUiEvents)
    }

    abstract fun handleUiEvents(events: UiEvent)

    private fun <T> startCollectingFlow(flow: Flow<T>, block: suspend (T) -> Unit) {
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