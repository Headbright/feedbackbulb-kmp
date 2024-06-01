package com.feedbackbulb.libs.toolbox

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable


@Composable
public fun FeedbackForm() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Share your thoughts...") },
        singleLine = true
    )
}