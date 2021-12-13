package com.composeplayground.tutor.domain.entities

data class CourseEntity(val courseId: Long,
                        val courseName: String,
                        val courseRating: Int,
                        val facilitator: Facilitator)
