package com.composeplayground.tutor.infra.repos

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseDetails
import com.composeplayground.tutor.infra.responses.CourseLesson
import kotlin.random.Random


val courseList = listOf(
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Jetpack Compose",
        rating = 3,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Arindom Ghosh"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "React Native",
        rating = 4,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Nandita Saha"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Node",
        rating = 3,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Nikitha Shetty"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Angular",
        rating = 4,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Mosh"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Data Scientist",
        rating = 4,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Samuel Jackson"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Jedi Force",
        rating = 5,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Master Yoda"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Flying Space Ship",
        rating = 5,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Captain Kirk"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Dark Arts",
        rating = 5,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Prof. Albus DumbleDore"
        )
    ),
    Course(
        courseId = Random.nextLong(6000, 8000),
        courseName = "Machine Learning",
        rating = 4,
        author = Course.Author(
            authorId = Random.nextLong(3000, 4000),
            authorName = "Jarvis"
        )
    )
)

val lessonDetailList = courseList.map {course->
    CourseDetails(
        course = course,
        courseLessons = List(10) {
            CourseLesson(
                lessonId = "${course.courseId}${Random.nextLong(10000, 12000)}".toLong(),
                lessonTitle = LoremIpsum(5).values.joinToString(" "),
                lessonContent = LoremIpsum(50).values.joinToString(" ")
            )
        }
    )
}
