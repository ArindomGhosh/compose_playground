package com.composeplayground.tutor.presentation.screens.courseDetails.courseDetailBloc

import android.util.Log
import com.composeplayground.mvi_core.FeatureBloc
import com.composeplayground.tutor.domain.DomainWrapper
import com.composeplayground.tutor.domain.usecases.LessonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class CourseDetailFeature @Inject constructor(
    private val lessonsUseCase: LessonsUseCase
) : FeatureBloc<CourseDetailEvent, CourseDetailState>(CourseDetailState()) {
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e(this@CourseDetailFeature::class.simpleName, "executeAsyncTask: ", exception.cause)
    }

    override fun postWish(wish: CourseDetailEvent) {
        when (wish) {
            is CourseDetailEvent.LoadCourseDetail -> loadCourseDetails(wish.courseId)
        }
    }

    private fun loadCourseDetails(courseId: Long) {
        postUiState(
            newUiState = uiState.value.copy(
                isLoading = true
            )
        )
        executeAsyncTask(coroutineExceptionHandler) {
            when (val courseDetailWrapper = lessonsUseCase.getLessons(courseId = courseId)) {
                is DomainWrapper.Error -> postUiState(
                    newUiState = uiState.value.copy(
                        isLoading = false,
                        error = courseDetailWrapper.uiError
                    )
                )
                is DomainWrapper.Success -> postUiState(
                    newUiState = uiState.value.copy(
                        isLoading = false,
                        data = courseDetailWrapper.data
                    )
                )
            }
        }
    }
}