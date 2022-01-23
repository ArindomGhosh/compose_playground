package com.composeplayground.tutor.presentation.screens.courses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.composeplayground.tutor.presentation.TutorBaseFragment
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseFeature
import com.composeplayground.tutor.presentation.screens.courses.courseBloc.CourseListEvent
import com.composeplayground.tutor.presentation.theme.TutorTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoursesFragment : TutorBaseFragment() {
    private val viewModel: CourseFeature by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.postWish(CourseListEvent.LoadCourse)
        return ComposeView(requireContext())
            .apply {
                setContent {
                    val courseListState by viewModel.uiState.collectAsState()
                    TutorTheme {
                        CourseScreen(
                            courseListState = courseListState,
                            reload = {
                                viewModel.postWish(CourseListEvent.LoadCourse)
                            },
                            onCourseSelected = { courseEntity ->
                                findNavController()
                                    .navigate(
                                        CoursesFragmentDirections.actionCoursesScreenToCourseDetailsFragment(
                                            courseId = courseEntity.courseId
                                        )
                                    )
                            }
                        )
                    }
                }
            }
    }
}