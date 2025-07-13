package com.dewa.kmtestone.ui.screens

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first", modifier = Modifier) {
        composable("first") { FirstScreen(navController) }
        composable(
            "second/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            SecondScreen(name = name, navController = navController)
        }
        composable("third") { ThirdScreen(navController = navController) }
        composable(
            route = "detail/{username}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val username = backStackEntry.arguments?.getString("username").orEmpty()
            SecondScreen(name = "", username = username, navController = navController)
        }
    }
}