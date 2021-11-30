package com.composeplayground.tutor.domain.entities

data class CourseEntity(val courseId: Int,
                        val courseName: String,
                        val courseRating: Int,
                        val facilitator: Facilitator)
