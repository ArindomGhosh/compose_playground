package com.composeplayground.tutor.exception

class CourseNotFoundException(val courseId: Long) :
    Throwable(message = "Course for $courseId not found")

class CourseDetailsNotFoundException(val courseId: Long) :
    Throwable(message = "Course details for $courseId not found")