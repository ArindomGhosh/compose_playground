package com.composeplayground.tutor.presentation.screens.courses.courseBloc

import com.composeplayground.mvi_core.FeatureBloc
import com.composeplayground.tutor.domain.DomainWrapper
import com.composeplayground.tutor.domain.usecases.CourseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class CourseFeature @Inject constructor(
    private val courseUseCase: CourseUseCase
) :
    FeatureBloc<CourseListEvent, CourseListState>(CourseListState()) {
    override fun postWish(wish: CourseListEvent) {
        when (wish) {
            CourseListEvent.LoadCourse -> {
                loadCourses()
            }
        }
    }

    private fun loadCourses() {
        postUiState(
            newUiState = uiState.value.copy(
                isLoading = true
            )
        )
        executeAsyncTask {
            when (val courseDomainWrapper = courseUseCase.getCourses()) {
                is DomainWrapper.Error -> postUiState(
                    newUiState = uiState.value.copy(
                        isLoading = false,
                        error = courseDomainWrapper.uiError
                    )
                )
                is DomainWrapper.Success -> postUiState(
                    newUiState = uiState.value.copy(
                        isLoading = false,
                        data = courseDomainWrapper.data
                    )
                )
            }

        }
    }
}