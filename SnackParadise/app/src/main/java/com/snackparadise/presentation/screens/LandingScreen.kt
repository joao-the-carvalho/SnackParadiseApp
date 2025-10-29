package com.snackparadise.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeliveryDining
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.snackparadise.presentation.components.AppScaffold
import com.snackparadise.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color(0xFF880000)

    DisposableEffect(systemUiController) {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = false
        )
        // deixei vazio pq antes tirava a cor da barra de status do celular :)
        onDispose {}
    }
    val scroll = rememberScrollState()

    // usa o AppScaffold com menu lateral
    AppScaffold(navController = navController, selectedItem = "home") {
        Column(
            modifier = Modifier
                .verticalScroll(scroll)
                .fillMaxSize()
        ) {
            // --- Seção 1: Boas-vindas ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFF1A0000), Color(0xFF6B0000))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        stringResource(R.string.welcome_snack),
                        fontSize = 32.sp,
                        color = Color.Yellow,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        stringResource(R.string.welcome_subtitle),
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(horizontal = 24.dp),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }

            // --- Seção 2: Delivery ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.verticalGradient(listOf(Color(0xFFFF0000), Color(0xFFAA0000))))
                    .padding(vertical = 60.dp, horizontal = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Filled.DeliveryDining,
                        contentDescription = "Delivery",
                        tint = Color.Yellow,
                        modifier = Modifier.size(60.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Delivery",
                        fontSize = 26.sp,
                        color = Color.Yellow,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        stringResource(R.string.delivery_desc),
                        color = Color.White,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = { navController.navigate("menu") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text("Pedir Delivery", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // --- Seção 3: Peça & Retire ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0A0A0A))
                    .padding(vertical = 60.dp, horizontal = 24.dp)
            ) {
                Column(horizontalAlignment = Alignment.Start) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Filled.ShoppingBag,
                            contentDescription = stringResource(R.string.order_delivery),
                            tint = Color.Yellow,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            stringResource(R.string.pickup),
                            color = Color.Yellow,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    Text(
                        stringResource(R.string.pickup_desc),
                        color = Color.White
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        stringResource(R.string.about_us),
                        color = Color.Yellow,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        stringResource(R.string.about_desc),
                        color = Color.White
                    )
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = { navController.navigate("menu") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(stringResource(R.string.order_pickup), color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // --- Seção 4: Vídeo ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.verticalGradient(listOf(Color(0xFFFFD600), Color(0xFFFF8800)))
                    )
                    .padding(vertical = 60.dp, horizontal = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        Icons.Filled.PlayArrow,
                        contentDescription = "Vídeo",
                        tint = Color.Black,
                        modifier = Modifier.size(60.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        stringResource(R.string.our_story),
                        fontSize = 26.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        stringResource(R.string.our_story_desc),
                        color = Color.Black,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Spacer(Modifier.height(24.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(180.dp)
                            .background(Color(0xFFB8860B), shape = RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                Icons.Filled.PlayArrow,
                                contentDescription = stringResource(R.string.video_sub),
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                            Text(stringResource(R.string.video_title), color = Color.White, fontWeight = FontWeight.Bold)
                            Text(stringResource(R.string.video_sub), color = Color.White.copy(alpha = 0.7f))
                        }
                    }
                }
            }
        }
    }
}
