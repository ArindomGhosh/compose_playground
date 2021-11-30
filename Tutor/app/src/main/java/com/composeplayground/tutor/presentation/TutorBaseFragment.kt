package com.composeplayground.tutor.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

abstract class TutorBaseFragment<
        UiState : TutorUiState<*>,
        UiEvent : TutorEvents,
        ViewModelType : TutorBaseViewModel<UiState, UiEvent>> : Fragment() {
    abstract val viewModel: ViewModelType

    fun postUiEvents(event: UiEvent) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.postEventAsync(event)
        }
    }
}