package com.example.nallnudi.ui.theme.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nallnudi.ui.theme.screens.AiTranslationScreen
import com.example.nallnudi.ui.theme.screens.FlashcardScreen
import com.example.nallnudi.ui.theme.screens.HomeScreen
import com.example.nallnudi.ui.theme.screens.ProfileScreen
import com.example.nallnudi.ui.theme.screens.SavedScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {

            HomeScreen()
        }

        composable("saved") {

            SavedScreen()
        }

        composable("profile") {

            ProfileScreen()
        }

        composable("ai") {

            AiTranslationScreen()
        }

        composable("flashcard") {

            FlashcardScreen()
        }
    }
}
