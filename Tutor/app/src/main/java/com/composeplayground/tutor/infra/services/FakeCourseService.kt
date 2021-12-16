package com.composeplayground.tutor.infra.services

import com.composeplayground.tutor.infra.repos.courseList
import com.composeplayground.tutor.infra.repos.lessonDetailList
import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseDetails
import javax.inject.Inject

class FakeCourseService @Inject constructor() : ICourseService {
    override fun getCourses(): List<Course> {
        return courseList
    }

    override fun getCourseFor(courseId: Long): Course? {
        return courseList.firstOrNull { it.courseId == courseId }
    }

    override fun getCourseDetails(courseId: Long): CourseDetails? {
        return lessonDetailList.firstOrNull { it.course.courseId == courseId }
    }
}