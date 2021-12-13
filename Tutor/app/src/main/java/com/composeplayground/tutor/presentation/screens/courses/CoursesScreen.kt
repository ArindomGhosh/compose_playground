package com.composeplayground.tutor.presentation.screens.courses

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.foundation.ValueChange
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListState
import com.composeplayground.tutor.presentation.theme.TutorTheme

@Composable
fun CourseScreen(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState,
    courseListState: CourseListState,
    onCourseSelected: ValueChange<CourseEntity>,
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            with(courseListState) {
                // todo if (isLoading) show loader
                // todo if(uiError)  show ErrorDialog
                // todo if(data) show courseList
                Courses(
                    modifier = modifier,
                    courseListState = courseListState,
                    onCourseSelected = onCourseSelected
                )
            }

        }
    }

}

@Composable
fun Courses(
    modifier: Modifier = Modifier,
    courseListState: CourseListState,
    onCourseSelected: ValueChange<CourseEntity>,
) {
    LazyColumn(modifier = modifier) {
        items(10) {
            CourseTile(
                courseEntity = CourseEntity(
                    courseId = 123,
                    courseName = "Compose",
                    courseRating = 5,
                    facilitator = Facilitator(
                        id = 615484,
                        name = "Arindom Ghosh"
                    )
                ), onCourseClick = onCourseSelected
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CourseTile(
    modifier: Modifier = Modifier,
    courseEntity: CourseEntity,
    onCourseClick: ValueChange<CourseEntity>
) {
    Card(
        modifier = modifier
            .padding(5.dp),
        onClick = { onCourseClick(courseEntity) },
        shape = MaterialTheme.shapes.large,
        elevation = 12.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Face, "")
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = courseEntity.courseName)
                    Text(text = "by ${courseEntity.facilitator.name}")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Rating: ${courseEntity.courseRating}")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CourseScreenPreview() {
    TutorTheme {
        CourseScreen(
            modifier = Modifier.padding(16.dp),
            scaffoldState = rememberScaffoldState(),
            onCourseSelected = {},
            courseListState = CourseListState(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CourseScreenDarkThemePreview() {
    TutorTheme(darkTheme = true) {
        CourseScreen(
            modifier = Modifier.padding(16.dp),
            scaffoldState = rememberScaffoldState(),
            onCourseSelected = {},
            courseListState = CourseListState(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesPreview() {
    TutorTheme {
        Courses(
            modifier = Modifier.padding(16.dp),
            onCourseSelected = {},
            courseListState = CourseListState(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesDarkThemePreview() {
    TutorTheme(darkTheme = true) {
        Courses(
            modifier = Modifier.padding(16.dp),
            onCourseSelected = {},
            courseListState = CourseListState(),
        )
    }
}

@Preview
@Composable
fun CoursePreview() {
    TutorTheme {
        CourseTile(
            courseEntity = CourseEntity(
                courseId = 123,
                courseName = "Compose",
                courseRating = 5,
                facilitator = Facilitator(
                    id = 615484,
                    name = "Arindom Ghosh"
                )
            ),
            onCourseClick = {})
    }
}

@Preview
@Composable
fun CourseDarkThemePreview() {
    TutorTheme(darkTheme = true) {
        CourseTile(
            courseEntity = CourseEntity(
                courseId = 123,
                courseName = "Compose",
                courseRating = 5,
                facilitator = Facilitator(
                    id = 615484,
                    name = "Arindom Ghosh"
                )
            ),
            onCourseClick = {})
    }
}