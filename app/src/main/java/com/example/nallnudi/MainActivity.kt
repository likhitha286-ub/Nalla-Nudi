package com.example.nallnudi
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.nallnudi.ui.theme.navigation.AppNavigation
import com.example.nallnudi.ui.theme.NallNudiTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            NallNudiTheme {

                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
