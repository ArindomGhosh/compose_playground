package com.composeplayground.tutor.presentation.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composeplayground.tutor.presentation.theme.TutorTheme


@Composable
fun TutorLoader(
    modifier: Modifier = Modifier,
    message: String
) {
    Box(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = message)
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseLoaderPreview() {
    TutorTheme {
        TutorLoader(message = "Loading..")
    }
}

@Preview(showBackground = true)
@Composable
fun CourseLoaderDarkThemePreview() {
    TutorTheme(darkTheme = true) {
        TutorLoader(message = "Loading..")
    }
}