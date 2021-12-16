package com.composeplayground.tutor.domain.mappers

import com.composeplayground.tutor.domain.entities.CourseDetailEntity
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.domain.entities.LessonEntity
import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseDetails
import com.composeplayground.tutor.infra.responses.CourseLesson

class LessonsDomainMapper : IDomainMapper<CourseDetails, CourseDetailEntity> {
    override fun mapToDomainModel(sourceModel: CourseDetails): CourseDetailEntity {
        return CourseDetailEntity(
            courseEntity = CourseEntity(
                courseId = sourceModel.course.courseId,
                courseName = sourceModel.course.courseName,
                courseRating = sourceModel.course.rating,
                facilitator = Facilitator(
                    id = sourceModel.course.author.authorId,
                    name = sourceModel.course.author.authorName
                )
            ),
            lessons = sourceModel
                .courseLessons
                .map {
                    LessonEntity(
                        lessonId = it.lessonId,
                        lessonTitle = it.lessonTitle,
                        lessonContent = it.lessonContent
                    )
                }
        )

    }

    override fun mapFromDomainModel(domainModel: CourseDetailEntity): CourseDetails {
        return CourseDetails(
            course = Course(
                courseId = domainModel.courseEntity.courseId,
                courseName = domainModel.courseEntity.courseName,
                rating = domainModel.courseEntity.courseRating,
                author = Course.Author(
                    authorId = domainModel.courseEntity.facilitator.id,
                    authorName = domainModel.courseEntity.facilitator.name
                )
            ),
            courseLessons = domainModel
                .lessons
                .map {
                    CourseLesson(
                        lessonId = it.lessonId,
                        lessonTitle = it.lessonTitle,
                        lessonContent = it.lessonContent
                    )
                }
        )
    }
}