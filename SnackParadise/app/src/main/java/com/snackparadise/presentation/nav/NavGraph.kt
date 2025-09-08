package com.snackparadise.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.snackparadise.presentation.screens.*

@Composable
fun NavGraph(startDestination: String = Screen.Landing.route) {
    val navController = rememberNavController()

    NavHost(navController, startDestination) {
        composable(Screen.Landing.route) {
            LandingScreen { navController.navigate(Screen.Menu.route) }
        }
        composable(Screen.Menu.route) {
            MenuScreen { navController.navigate(Screen.Checkout.route) }
        }
        composable(Screen.Checkout.route) {
            CheckoutScreen()
        }
        composable(Screen.Login.route) {
            LoginScreen()
        }
    }
}