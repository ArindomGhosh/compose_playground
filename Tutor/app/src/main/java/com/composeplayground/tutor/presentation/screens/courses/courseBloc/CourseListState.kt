package com.composeplayground.tutor.presentation.screens.courses.courseBloc

import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.UiError
import com.composeplayground.tutor.presentation.TutorUiState

data class CourseListState(override val data: List<CourseEntity> = emptyList(),
                           override val isLoading: Boolean = false,
                           override val error: UiError? = null) : TutorUiState<List<CourseEntity>>

fun CourseListState.loading() = this.copy(isLoading = true)
fun CourseListState.loaded(courseList: List<CourseEntity>) = this
        .copy(isLoading = false,
                data = courseList,
                error = null)

fun CourseListState.onError(uiError: UiError) = this.copy(
        isLoading = false,
        error = uiError
)