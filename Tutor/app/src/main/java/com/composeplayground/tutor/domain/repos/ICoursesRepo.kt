package com.composeplayground.tutor.domain.repos

import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseLesson
import kotlinx.coroutines.flow.Flow

interface ICoursesRepo {
    fun getCourses(): Flow<CourseResponse<List<Course>>>
    fun getCourseFor(courseId: Long): Flow<CourseResponse<Course>>
    fun getLessonsForCourse(courseId: Long): Flow<CourseResponse<List<CourseLesson>>>
}