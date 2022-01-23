package com.composeplayground.tutor.infra.repos

import com.composeplayground.tutor.domain.repos.CourseResponse
import com.composeplayground.tutor.domain.repos.ICoursesRepo
import com.composeplayground.tutor.exception.CourseDetailsNotFoundException
import com.composeplayground.tutor.exception.CourseNotFoundException
import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseDetails
import com.composeplayground.tutor.infra.services.ICourseService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepoImpl @Inject constructor(
    private val courseService: ICourseService
) : ICoursesRepo {
    override fun getCourses(): Flow<CourseResponse<List<Course>>> {
        return flow {
            delay(3000)
//            emit(CourseResponse.Error(Throwable()))
            emit(CourseResponse.Success(courseService.getCourses()))
        }
    }

    override fun getCourseFor(courseId: Long): Flow<CourseResponse<Course>> {
        val course = courseService.getCourseFor(courseId = courseId)
        return flow {
            delay(3000)
            course?.let {
                emit(CourseResponse.Success(it))
            } ?: run {
                emit(
                    CourseResponse.Error<Course>(
                        throwable = CourseNotFoundException(courseId = courseId)
                    )
                )
            }
        }
    }

    override fun getLessonsForCourse(courseId: Long): Flow<CourseResponse<CourseDetails>> {
        val courseDetail = courseService.getCourseDetails(courseId = courseId)
        return flow {
            delay(3000)
            courseDetail?.let {
                emit(CourseResponse.Success(it))
            } ?: run {
                emit(
                    CourseResponse.Error<CourseDetails>(
                        throwable = CourseDetailsNotFoundException(courseId = courseId)
                    )
                )
            }
        }
    }
}