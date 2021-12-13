package com.composeplayground.tutor.domain.mappers

import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.infra.responses.Course

class CoursesDomainMapper : IDomainMapper<List<Course>, List<CourseEntity>> {
    override fun mapToDomainModel(sourceModel: List<Course>): List<CourseEntity> {
        return sourceModel.map {
            CourseEntity(
                courseId = it.courseId,
                courseName = it.courseName,
                courseRating = it.rating,
                facilitator = Facilitator(
                    id = it.author.authorId,
                    name = it.author.authorName
                )
            )
        }
    }

    override fun mapFromDomainModel(domainModel: List<CourseEntity>): List<Course> {
        return domainModel.map {
            Course(
                courseId = it.courseId,
                courseName = it.courseName,
                rating = it.courseRating,
                author = Course.Author(
                    authorId = it.facilitator.id,
                    authorName = it.facilitator.name
                )
            )
        }
    }
}