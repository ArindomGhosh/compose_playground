package com.composeplayground.tutor.presentation.screens.courseDetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material.icons.twotone.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeplayground.tutor.presentation.screens.courseDetails.courseDetailBloc.CourseDetailState
import com.composeplayground.tutor.presentation.widgets.TutorLoader
import com.composeplayground.tutor.R
import com.composeplayground.tutor.domain.entities.LessonEntity
import com.composeplayground.tutor.foundation.VoidCallback
import com.composeplayground.tutor.presentation.theme.TutorTheme
import com.composeplayground.tutor.presentation.widgets.TutorAlertAction
import kotlin.random.Random

@Composable
fun CourseDetailsScreen(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    courseDetailState: CourseDetailState,
    onLoadingError: VoidCallback
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                courseDetailState.isLoading -> TutorLoader(
                    message = LocalContext.current.getString(
                        R.string.loading_details
                    )
                )
                courseDetailState.error != null -> {
                    TutorAlertAction(
                        title = courseDetailState.error.header,
                        text = courseDetailState.error.message,
                        action = onLoadingError
                    )
                }
                else -> {
                    Lessons(lessons = courseDetailState.data.lessons)
                }
            }
        }
    }
}

@Composable
fun Lessons(
    modifier: Modifier = Modifier,
    lessons: List<LessonEntity>
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        var currentLessonIdx by remember { mutableStateOf(0) }
        if (currentLessonIdx > 0) {
            IconButton(
                modifier = Modifier.align(Alignment.BottomStart),
                onClick = { currentLessonIdx-- }) {
                Icon(
                    imageVector = Icons.TwoTone.ArrowBack,
                    contentDescription = LocalContext.current.getString(R.string.previous_lesson)
                )
            }
        }
        //did preview rendering
        lessons.elementAtOrNull(currentLessonIdx)?.let {
            Lesson(lesson = it)
        }

        if (currentLessonIdx < lessons.lastIndex) {
            IconButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = { currentLessonIdx++ }) {
                Icon(
                    imageVector = Icons.TwoTone.ArrowForward,
                    contentDescription = LocalContext.current.getString(R.string.next_lesson)
                )

            }
        }

    }
}

@Composable
fun Lesson(
    modifier: Modifier = Modifier,
    lesson: LessonEntity
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = lesson.lessonTitle,
            style = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 2.sp
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = lesson.lessonContent,
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 16.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LessonsPreview() {
    TutorTheme {
        Lessons(lessons = emptyList())
    }
}

@Preview(showBackground = true)
@Composable
fun LessonPreview() {
    TutorTheme {
        Lesson(
            lesson = LessonEntity(
                lessonId = "${Random.nextLong(10000, 12000)}".toLong(),
                lessonTitle = LoremIpsum(5).values.joinToString(" "),
                lessonContent = LoremIpsum(50).values.joinToString(" ")
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LessonDarkThemePreview() {
    TutorTheme(darkTheme = true) {
        Lesson(
            lesson = LessonEntity(
                lessonId = "${Random.nextLong(10000, 12000)}".toLong(),
                lessonTitle = LoremIpsum(5).values.joinToString(" "),
                lessonContent = LoremIpsum(50).values.joinToString(" ")
            )
        )
    }
}