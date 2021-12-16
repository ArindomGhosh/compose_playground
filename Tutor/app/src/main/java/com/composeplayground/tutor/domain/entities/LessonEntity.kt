package com.composeplayground.tutor.domain.entities

data class CourseDetailEntity(
    val courseEntity: CourseEntity,
    val lessons: List<LessonEntity>
)

data class LessonEntity(
    val lessonId: Long,
    val lessonTitle: String,
    val lessonContent: String
)
