package com.composeplayground.tutor.presentation.screens.courseDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.composeplayground.tutor.presentation.TutorBaseFragment
import com.composeplayground.tutor.presentation.screens.courseDetails.courseDetailBloc.CourseDetailEvent
import com.composeplayground.tutor.presentation.screens.courseDetails.courseDetailBloc.CourseDetailFeature
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailsFragment : TutorBaseFragment() {
    private val courseFeature: CourseDetailFeature by viewModels()
    private val argument by navArgs<CourseDetailsFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        courseFeature.postWish(CourseDetailEvent.LoadCourseDetail(argument.courseId))
        return ComposeView(requireContext())
            .apply {
                setContent {
                    val courseDetailState by courseFeature.uiState.collectAsState()
                    CourseDetailsScreen(courseDetailState = courseDetailState,
                        onLoadingError = {
                            findNavController().popBackStack()
                        })
                }
            }
    }
}