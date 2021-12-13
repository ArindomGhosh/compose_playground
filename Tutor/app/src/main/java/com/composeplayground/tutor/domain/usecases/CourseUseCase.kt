package com.composeplayground.tutor.domain.usecases

import com.composeplayground.tutor.domain.DomainWrapper
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.mapToDomainWrapper
import com.composeplayground.tutor.domain.mappers.IDomainMapper
import com.composeplayground.tutor.domain.repos.ICoursesRepo
import com.composeplayground.tutor.infra.responses.Course
import kotlinx.coroutines.flow.single

class CourseUseCase(
    private val coursesRepo: ICoursesRepo,
    private val courseListIDomainMapper: IDomainMapper<List<Course>, List<CourseEntity>>,
    private val courseIDomainMapper: IDomainMapper<Course, CourseEntity>
) {
    suspend fun getCourses(): DomainWrapper<List<CourseEntity>> {
        return coursesRepo.getCourses()
            .single()
            .mapToDomainWrapper(courseListIDomainMapper)
    }

    suspend fun getCourseForCourseId(courseId: Long): DomainWrapper<CourseEntity> {
        return coursesRepo.getCourseFor(courseId = courseId)
            .single()
            .mapToDomainWrapper(courseIDomainMapper)
    }
}