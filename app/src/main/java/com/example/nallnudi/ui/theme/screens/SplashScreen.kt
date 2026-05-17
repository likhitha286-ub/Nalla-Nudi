package com.example.nallnudi.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nallnudi.ui.theme.PrimaryBlue

@Composable
fun SplashScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Nalla-Nudi",
            color = PrimaryBlue,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
