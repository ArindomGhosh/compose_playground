package com.composeplayground.tutor.presentation.screens.courses.courseBloc

import com.composeplayground.mvi_core.FeatureBloc
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.domain.usecases.CourseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CourseFeature @Inject constructor(
    private val courseUseCase: CourseUseCase
) :
    FeatureBloc<CourseListEvent, CourseListState>(CourseListState()) {
    override fun postWish(wish: CourseListEvent) {
        when (wish) {
            CourseListEvent.LoadCourse -> {
                postUiState(
                    newUiState = uiState.value.copy(
                        data = listOf(
                            CourseEntity(
                                courseId = 12,
                                courseName = "Compose",
                                courseRating = 5,
                                facilitator = Facilitator(id = 465421651, name = "Arindom Ghosh")
                            )
                        )
                    )
                )
            }
        }
    }
}