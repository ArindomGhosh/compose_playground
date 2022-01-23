package com.composeplayground.tutor.presentation.screens.courseDetails.courseDetailBloc

import com.composeplayground.tutor.domain.entities.CourseDetailEntity
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.domain.entities.UiError
import com.composeplayground.tutor.presentation.TutorUiState

data class CourseDetailState(
    override val data: CourseDetailEntity = CourseDetailEntity(
        courseEntity = CourseEntity(
            courseId = Long.MIN_VALUE,
            courseName = "",
            courseRating = Int.MIN_VALUE,
            facilitator = Facilitator(
                id = Long.MIN_VALUE,
                name = ""
            )
        ),
        lessons = emptyList()
    ),
    override val isLoading: Boolean = false,
    override val error: UiError? = null
) : TutorUiState<CourseDetailEntity>

fun CourseDetailState.loading() = this.copy(isLoading = true)
fun CourseDetailState.loaded(courseDetailEntity: CourseDetailEntity) = this
    .copy(
        isLoading = false,
        data = courseDetailEntity,
        error = null
    )

fun CourseDetailState.onError(uiError: UiError) = this.copy(
    isLoading = false,
    error = uiError
)
