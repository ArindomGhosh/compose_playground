package com.composeplayground.tutor.presentation.screens.courses.courseBloc

import com.composeplayground.tutor.presentation.TutorEvents

sealed class CourseListEvent : TutorEvents {
    object LoadCourse : CourseListEvent()
}
