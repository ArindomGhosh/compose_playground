package com.composeplayground.tutor.presentation.screens.courses

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composeplayground.tutor.R
import com.composeplayground.tutor.domain.entities.CourseEntity
import com.composeplayground.tutor.domain.entities.Facilitator
import com.composeplayground.tutor.foundation.ValueChange
import com.composeplayground.tutor.foundation.VoidCallback
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListState
import com.composeplayground.tutor.presentation.theme.TutorTheme
import com.composeplayground.tutor.presentation.widgets.TutorLoader
import com.composeplayground.tutor.presentation.widgets.TutorAlertAction
import kotlinx.coroutines.CoroutineScope

/**
 * SaveableStateProvider: https://developer.android.com/reference/kotlin/androidx
 * /compose/runtime/saveable/SaveableStateHolder#SaveableStateProvider(kotlin.Any,kotlin.Function0)
 * **/

@Composable
fun CourseScreen(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    courseListState: CourseListState,
    reload: VoidCallback,
    onCourseSelected: ValueChange<CourseEntity>,
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        //if not override would use the default one
        /*snackbarHost = {
            SnackbarHost(hostState = it) { data ->
                Snackbar(
                    modifier = Modifier.border(2.dp, MaterialTheme.colors.secondary),
                    snackbarData = data,
                )
            }
        },*/
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            when {
                courseListState.isLoading -> TutorLoader(
                    modifier = modifier,
                    message = LocalContext.current.getString(R.string.course_loading_message)
                )
                courseListState.error != null -> {
                    TutorAlertAction(
                        title = courseListState.error.header,
                        text = courseListState.error.message,
                        action = reload
                    )
                }
                else -> {
                    Courses(
                        modifier = modifier,
                        courseListState = courseListState,
                        onCourseSelected = onCourseSelected
                        /*{
                            //https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#snackbar
                            coroutineScope.launch {
                                val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "You selected ${it.courseName}!!",
                                    actionLabel= "Retry"
                                )
                                when(snackBarResult){
                                    SnackbarResult.Dismissed -> Log.i("CourseScreen", "Snackbar Dismissed ")
                                    SnackbarResult.ActionPerformed -> Log.i("CourseScreen", "Snackbar action performed ")
                                }
                            }
                        }*/
                    )
                }
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
        items(courseListState.data) { courseEntity ->
            CourseTile(
                courseEntity = courseEntity,
                onCourseClick = onCourseSelected
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
            courseListState = CourseListState(isLoading = true),
            reload = {},
            onCourseSelected = {},
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
            reload = {},
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