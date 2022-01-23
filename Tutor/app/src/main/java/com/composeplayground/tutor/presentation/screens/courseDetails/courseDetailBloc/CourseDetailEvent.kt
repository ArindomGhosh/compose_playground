package com.composeplayground.tutor.presentation.screens.courseDetails.courseDetailBloc

import com.composeplayground.tutor.presentation.TutorEvents

sealed class CourseDetailEvent : TutorEvents {
    data class LoadCourseDetail(val courseId: Long) : CourseDetailEvent()
}
