package com.composeplayground.tutor.presentation.screens.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.composeplayground.tutor.presentation.TutorBaseFragment
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListEvent
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListState
import com.composeplayground.tutor.presentation.theme.TutorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoursesFragment : TutorBaseFragment<CourseListState, CourseListEvent,
        CourseListViewModel>() {
    override val viewModel: CourseListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    val scaffoldState = rememberScaffoldState()
                    postUiEvents(CourseListEvent.LoadCourse)
                    val courseListState by viewModel.uiState.collectAsState()
                    TutorTheme {
                        CoursesScreen(
                            scaffoldState = scaffoldState,
                            courseListState = courseListState,
                            onCourseSelected = { courseEntity ->
                                // todo navigate to Course detail Entity
                            }
                        ) {
                            Greeting(name = "Android")
                        }
                    }
                }
            }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TutorTheme {
        CoursesScreen(
            modifier = Modifier.padding(16.dp),
            scaffoldState = rememberScaffoldState(),
            onCourseSelected = {},
            courseListState = CourseListState(),
        ) {
            Greeting("Android")
        }
    }
}