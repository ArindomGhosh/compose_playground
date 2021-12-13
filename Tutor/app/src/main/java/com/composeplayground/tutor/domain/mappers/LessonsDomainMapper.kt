package com.composeplayground.tutor.domain.mappers

import com.composeplayground.tutor.domain.entities.LessonEntity
import com.composeplayground.tutor.infra.responses.CourseLesson

class LessonsDomainMapper : IDomainMapper<List<CourseLesson>, List<LessonEntity>> {
    override fun mapToDomainModel(sourceModel: List<CourseLesson>): List<LessonEntity> {
        return sourceModel
            .map {
                LessonEntity(
                    lessonId = it.lessonId,
                    lessonTitle = it.lessonTitle,
                    lessonContent = it.lessonContent
                )
            }
    }

    override fun mapFromDomainModel(domainModel: List<LessonEntity>): List<CourseLesson> {
        return domainModel
            .map {
                CourseLesson(
                    lessonId = it.lessonId,
                    lessonTitle = it.lessonTitle,
                    lessonContent = it.lessonContent
                )
            }
    }
}