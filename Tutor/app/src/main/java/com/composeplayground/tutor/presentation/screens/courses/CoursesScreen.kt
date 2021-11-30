package com.composeplayground.tutor.presentation.screens.courses

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.foundation.ValueChange
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListState

@Composable
fun CoursesScreen(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState,
    courseListState: CourseListState,
    onCourseSelected: ValueChange<CourseEntity>,
    contentHandler: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            with(courseListState) {
                // todo if (isLoading) show loader
                // todo if(uiError)  show ErrorDialog
                // todo if(data) show courseList
                contentHandler()
            }

        }
    }
}
