package com.composeplayground.tutor.presentation.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composeplayground.tutor.R
import com.composeplayground.tutor.foundation.VoidCallback
import com.composeplayground.tutor.presentation.theme.TutorTheme

@Composable
fun TutorAlertInfo(
    modifier: Modifier = Modifier,
    title: String,
    text: String
) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = text)
            },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { openDialog.value = false }) {
                        Text(text = LocalContext.current.getString(R.string.dismiss))
                    }
                }
            }
        )
    }
}

@Composable
fun TutorAlertAction(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    action: VoidCallback
) {

    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = title)
            },
            text = {
                Text(text = text)
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    verticalAlignment= Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { openDialog.value = false }) {
                        Text(text = LocalContext.current.getString(R.string.dismiss))
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = action
                    ) {
                        Text(text = LocalContext.current.getString(R.string.confirm))
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TutorAlertInfoPreview() {
    TutorTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center,
        ) {
            TutorAlertInfo(title = "Alert", text = "Alert Message")
        }
    }
}