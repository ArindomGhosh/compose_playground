package com.composeplayground.tutor.presentation.screens.courses

import com.composeplayground.tutor.presentation.TutorBaseViewModel
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListEvent
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CourseListViewModel @Inject constructor()
    : TutorBaseViewModel<CourseListState, CourseListEvent>() {
    private val _uiMutableState: MutableStateFlow<CourseListState> = MutableStateFlow(CourseListState())

    override fun handleUiEvents(events: CourseListEvent) {
        when(events){
            CourseListEvent.LoadCourse -> {
                // todo call courseLoad UseCase here
            }
        }
    }

    override val uiState: StateFlow<CourseListState>
        get() = _uiMutableState.asStateFlow()

}