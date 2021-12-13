package com.composeplayground.tutor.domain.repos

sealed class CourseResponse<Response> {
    data class Error<Response>(val throwable: Throwable) : CourseResponse<Response>()
    data class Success<Response>(val data: Response) : CourseResponse<Response>()
}
