package com.composeplayground.tutor.infra.responses

data class CourseDetails(
    val course: Course,
    val courseLessons: List<CourseLesson>
)

data class CourseLesson(
    val lessonId: Long,
    val lessonTitle: String,
    val lessonContent: String
)
