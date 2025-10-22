package com.snackparadise.presentation.nav

sealed class Screen(val route: String) {
    object Landing : Screen("landing")
    object OrderType : Screen("ordertype")
    object Menu : Screen("menu")
    object Checkout : Screen("checkout")
    object Login : Screen("login")
}