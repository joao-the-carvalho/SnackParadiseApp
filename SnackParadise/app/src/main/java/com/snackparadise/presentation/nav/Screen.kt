package com.snackparadise.presentation.nav

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object OrderType : Screen("ordertype")
    object Menu : Screen("menu")
    object Checkout : Screen("checkout")
    object Logreg : Screen("logreg")
    object Profile : Screen("profile")
    object Auth : Screen("auth")
    object Sobre : Screen("sobre")
    object Pontos : Screen("pontos")
}
