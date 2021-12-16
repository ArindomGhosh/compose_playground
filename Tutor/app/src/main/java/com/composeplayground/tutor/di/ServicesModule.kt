package com.composeplayground.tutor.di

import com.composeplayground.tutor.infra.services.FakeCourseService
import com.composeplayground.tutor.infra.services.ICourseService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServicesModule {

    @Singleton
    @Binds
    abstract fun bindCourseService(fakeCourseService: FakeCourseService):ICourseService
}