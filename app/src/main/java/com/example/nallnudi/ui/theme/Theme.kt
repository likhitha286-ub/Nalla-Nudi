package com.example.nallnudi.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = PrimaryBlue
)

@Composable
fun NallNudiTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}