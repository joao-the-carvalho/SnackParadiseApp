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
import com.snackparadise.R
import androidx.compose.ui.res.stringResource
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
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Divider(color = Color.White.copy(alpha = 0.3f))
                DrawerItem(stringResource(R.string.drawer_home), selectedItem == "landing") { navController.navigate("landing") }
                DrawerItem(stringResource(R.string.drawer_login), selectedItem == "auth") { navController.navigate("auth") }
                DrawerItem(stringResource(R.string.drawer_menu), selectedItem == "menu") { navController.navigate("menu") }
                DrawerItem(stringResource(R.string.drawer_profile), selectedItem == "profile") { navController.navigate("profile") }
                DrawerItem(stringResource(R.string.drawer_about), selectedItem == "sobre") { navController.navigate("sobre") }
                /*DrawerItem(stringResource(R.string.drawer_checkout), selectedItem == "checkout") { navController.navigate("checkout") } não é pra isso aqui aparecer no video*/
                DrawerItem(stringResource(R.string.drawer_points), selectedItem == "pontos"){ navController.navigate("pontos") }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {},
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
