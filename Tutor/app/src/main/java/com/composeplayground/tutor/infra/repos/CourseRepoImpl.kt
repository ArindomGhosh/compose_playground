package com.composeplayground.tutor.infra.repos

import com.composeplayground.tutor.domain.repos.CourseResponse
import com.composeplayground.tutor.domain.repos.ICoursesRepo
import com.composeplayground.tutor.infra.responses.Course
import com.composeplayground.tutor.infra.responses.CourseLesson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CourseRepoImpl @Inject constructor():ICoursesRepo {
    override fun getCourses(): Flow<CourseResponse<List<Course>>> {
       return flow {
           emit(CourseResponse.Success(emptyList<Course>()))
       }
    }

    override fun getCourseFor(courseId: Long): Flow<CourseResponse<Course>> {
       return flow {
           emit(CourseResponse.Success(
               Course(
               courseId = 456143546L,
               courseName = "Compose",
               author = Course.Author(
                   authorId = 465412132L,
                   authorName = "Arindom Ghosh"
               ),
               rating = 5
           )
           ))
       }
    }

    override fun getLessonsForCourse(courseId: Long): Flow<CourseResponse<List<CourseLesson>>> {
        return flow {
            emit(CourseResponse.Success(emptyList()))
        }
    }
}