package com.composeplayground.tutor.domain.mappers

import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.infra.responses.Course

class CourseDomainMapper : IDomainMapper<Course, CourseEntity> {
    override fun mapToDomainModel(sourceModel: Course): CourseEntity {
        return CourseEntity(
            courseId = sourceModel.courseId,
            courseName = sourceModel.courseName,
            courseRating = sourceModel.rating,
            facilitator = Facilitator(
                id = sourceModel.author.authorId,
                name = sourceModel.author.authorName
            )
        )
    }

    override fun mapFromDomainModel(domainModel: CourseEntity): Course {
        return Course(
            courseId = domainModel.courseId,
            courseName = domainModel.courseName,
            rating = domainModel.courseRating,
            author = Course.Author(
                authorId = domainModel.facilitator.id,
                authorName = domainModel.facilitator.name
            )
        )
    }
}