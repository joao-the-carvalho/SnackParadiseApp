package com.snackparadise.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Checkout") }) }
    ) { padding ->
        Text("Tela de Checkout", modifier = androidx.compose.ui.Modifier.padding(padding))
    }
}