package com.composeplayground.tutor.di

import com.composeplayground.tutor.domain.mappers.CourseDomainMapper
import com.composeplayground.tutor.domain.mappers.CoursesDomainMapper
import com.composeplayground.tutor.domain.mappers.LessonsDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainMapperModule {

    @Singleton
    @Provides
    fun bindCoursesDomainMapper(): CoursesDomainMapper{
        return CoursesDomainMapper()
    }

    @Singleton
    @Provides
    fun bindCourseDomainMapper(): CourseDomainMapper{
        return CourseDomainMapper()
    }


    @Singleton
    @Provides
    fun bindLessonDomainMapper(): LessonsDomainMapper{
        return LessonsDomainMapper()
    }


}