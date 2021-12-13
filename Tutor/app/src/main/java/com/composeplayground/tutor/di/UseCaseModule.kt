package com.composeplayground.tutor.di

import com.composeplayground.tutor.domain.mappers.CourseDomainMapper
import com.composeplayground.tutor.domain.mappers.CoursesDomainMapper
import com.composeplayground.tutor.domain.mappers.LessonsDomainMapper
import com.composeplayground.tutor.domain.repos.ICoursesRepo
import com.composeplayground.tutor.domain.usecases.CourseUseCase
import com.composeplayground.tutor.domain.usecases.LessonsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun bindCourseUseCase(
        courRepo: ICoursesRepo,
        coursesDomainMapper: CoursesDomainMapper,
        courseDomainMapper: CourseDomainMapper
    ): CourseUseCase {
        return CourseUseCase(
            coursesRepo = courRepo,
            courseListIDomainMapper = coursesDomainMapper,
            courseIDomainMapper = courseDomainMapper
        )
    }

    @Singleton
    @Provides
    fun bindLessonUseCase(
        courRepo: ICoursesRepo,
        lessonsDomainMapper: LessonsDomainMapper
    ): LessonsUseCase {
        return LessonsUseCase(
            courseRepo = courRepo,
            lessonsDomainMapper = lessonsDomainMapper
        )
    }
}
