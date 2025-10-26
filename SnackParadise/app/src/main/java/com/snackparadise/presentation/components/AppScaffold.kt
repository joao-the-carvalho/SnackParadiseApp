package com.snackparadise.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    navController: NavController,
    selectedItem: String = "",
    content: @Composable () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(240.dp),
                drawerContainerColor = Color(0xFF7A0000)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Snack Paradise",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Divider(color = Color.White.copy(alpha = 0.3f))
                DrawerItem("Tela Inicial", selectedItem == "landing") { navController.navigate("landing") }
                DrawerItem("Menu", selectedItem == "menu") { navController.navigate("menu") }
                DrawerItem("Login/Registro", selectedItem == "logreg") { navController.navigate("logreg") }
                DrawerItem("Perfil", selectedItem == "profile") { navController.navigate("profile") }
                DrawerItem("Sobre Nós", selectedItem == "sobre") { navController.navigate("sobre") }
                DrawerItem("Checkout", selectedItem == "checkout") { navController.navigate("checkout") }
                DrawerItem("Pontos", selectedItem == "pontos"){navController.navigate("pontos")}
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {}, // removido o título
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFCC0000)
                    )
                )
            },
            containerColor = Color.Transparent
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                content()
            }
        }
    }
}

@Composable
private fun DrawerItem(text: String, selected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (selected) Color.White.copy(alpha = 0.2f) else Color.Transparent
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
