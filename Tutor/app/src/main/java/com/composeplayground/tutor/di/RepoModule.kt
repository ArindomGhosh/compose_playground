package com.composeplayground.tutor.di

import com.composeplayground.tutor.domain.repos.ICoursesRepo
import com.composeplayground.tutor.infra.repos.CourseRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Singleton
    @Binds
    abstract fun bindCourseRepo(courseRepoImpl: CourseRepoImpl): ICoursesRepo
}