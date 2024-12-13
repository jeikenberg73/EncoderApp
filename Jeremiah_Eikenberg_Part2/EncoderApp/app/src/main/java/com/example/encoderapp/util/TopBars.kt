package com.example.encoderapp.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.encoderapp.ui.theme.BlueGradiantBackgroundStart
import com.example.encoderapp.ui.theme.BlueGradiantBackgroundStop

@Composable
fun MainTopBar(
    title: String,
    modifier: Modifier = Modifier
) {
    // Title bar layout
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(title)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainTopBarPreview() {
    MainTopBar("Encode Decode App", Modifier.fillMaxWidth())
}