package com.composeplayground.tutor.infra.responses

data class Course(
    val courseId: Long,
    val courseName: String,
    val rating: Int,
    val author: Author
) {
    data class Author(
        val authorId: Long,
        val authorName: String
    )
}
