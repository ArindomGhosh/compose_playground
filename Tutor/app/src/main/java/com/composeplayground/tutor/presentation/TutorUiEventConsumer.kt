package com.composeplayground.tutor.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

interface ITutorUiEventConsumer<Event : TutorEvents> {
    val events: Flow<Event>
    suspend fun postEventAsync(uiEvent: Event)
}

class TutorUiEventConsumerImpl<Event : TutorEvents>:ITutorUiEventConsumer<Event>{
    private val _uiEvent = MutableSharedFlow<Event>()
    override val events: Flow<Event>
        get() = _uiEvent

    override suspend fun postEventAsync(uiEvent: Event) {
        _uiEvent.emit(uiEvent)
    }
}