package com.example.nallnudi.ui.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color.White
    ) {

        NavigationBarItem(
            selected = currentRoute == "home",
            onClick = {
                navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }
            },
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = null,
                    tint = if (currentRoute == "home") Color.Blue else Color.Gray
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = currentRoute == "ai",
            onClick = {
                navController.navigate("ai")
            },
            icon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = if (currentRoute == "ai") Color.Blue else Color.Gray
                )
            },
            label = {
                Text("AI")
            }
        )

        NavigationBarItem(
            selected = currentRoute == "profile",
            onClick = {
                navController.navigate("profile")
            },
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = if (currentRoute == "profile") Color.Blue else Color.Gray
                )
            },
            label = {
                Text("Profile")
            }
        )
    }
}
