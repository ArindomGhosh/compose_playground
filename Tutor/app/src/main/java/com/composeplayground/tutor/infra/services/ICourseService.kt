package com.composeplayground.tutor.infra.services

import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseDetails

interface ICourseService {
    fun getCourses(): List<Course>
    fun getCourseFor(courseId: Long): Course?
    fun getCourseDetails(courseId: Long): CourseDetails?
}