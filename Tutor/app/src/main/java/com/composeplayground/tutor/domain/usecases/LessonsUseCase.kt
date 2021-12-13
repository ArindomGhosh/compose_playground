package com.composeplayground.tutor.domain.usecases

import com.composeplayground.tutor.domain.DomainWrapper
import com.composeplayground.tutor.domain.entities.LessonEntity
import com.composeplayground.tutor.domain.mapToDomainWrapper
import com.composeplayground.tutor.domain.mappers.IDomainMapper
import com.composeplayground.tutor.domain.repos.ICoursesRepo
import com.composeplayground.tutor.infra.responses.CourseLesson
import kotlinx.coroutines.flow.single

class LessonsUseCase(
    private val courseRepo: ICoursesRepo,
    private val lessonsDomainMapper: IDomainMapper<List<CourseLesson>, List<LessonEntity>>
) {
    suspend fun getLessons(courseId: Long): DomainWrapper<List<LessonEntity>> {
        return courseRepo.getLessonsForCourse(courseId)
            .single()
            .mapToDomainWrapper(lessonsDomainMapper)
    }
}