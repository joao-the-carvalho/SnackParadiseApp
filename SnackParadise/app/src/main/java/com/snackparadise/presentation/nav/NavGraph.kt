    package com.snackparadise.presentation.nav

    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.rememberNavController
    import com.snackparadise.data.model.MenuItem
    import com.snackparadise.presentation.screens.*
    import com.snackparadise.presentation.viewmodel.CartViewModel

    @Composable
    fun NavGraph(startDestination: String = Screen.Landing.route) {
        val navController = rememberNavController()

        NavHost(navController, startDestination) {
            composable(Screen.Landing.route) {
                LandingScreen(navController)
            }
            composable(Screen.OrderType.route) {
                OrderTypeScreen(navController)
            }
            composable(Screen.Menu.route) {
                MenuScreen(navController)
            }
            composable(Screen.Checkout.route) {
                val cartViewModel: CartViewModel = viewModel()
                val cartItems: List<MenuItem> by cartViewModel.cartItems.collectAsState()
                CheckoutScreen(navController, cartItems = cartItems)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navController)
            }
            composable(Screen.Auth.route) {
                AuthScreen(navController)
            }
            composable(Screen.Sobre.route) {
                SobreScreen(navController)
            }
            composable(Screen.Pontos.route){
                PontosScreen(navController)
            }
            composable(Screen.Confirma.route){
                ConfirmationScreen(navController)
            }
        }

    }