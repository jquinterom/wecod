package com.example.wecod.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingWheel() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics { testTag = "loading-wheel" },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.secondary
        )
    }
}


@Preview
@Composable
fun PreviewLoadingWheel(){
    MaterialTheme{
        LoadingWheel()
    }
}