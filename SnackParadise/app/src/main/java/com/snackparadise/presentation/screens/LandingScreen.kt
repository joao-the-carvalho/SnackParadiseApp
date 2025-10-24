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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.snackparadise.presentation.components.AppScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(navController: NavController) {

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
                        "Bem-vindo ao Snack Paradise",
                        fontSize = 32.sp,
                        color = Color.Yellow,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "O seu paraíso dos lanches está aqui! Sabores únicos, ingredientes frescos e muito amor em cada mordida.",
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
                        "Receba seus lanches favoritos no conforto da sua casa! Entrega rápida, segura e sempre quentinha.",
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
                            contentDescription = "Retire",
                            tint = Color.Yellow,
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Peça & Retire",
                            color = Color.Yellow,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Faça seu pedido online e retire na nossa loja sem filas ou esperas. Rápido e prático!",
                        color = Color.White
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "Sobre o Snack Paradise",
                        color = Color.Yellow,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Fundado em 2020, o Snack Paradise nasceu do sonho de criar o melhor hambúrguer da cidade.",
                        color = Color.White
                    )
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = { navController.navigate("menu") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text("Pedir para Retirar", color = Color.Black, fontWeight = FontWeight.Bold)
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
                        "Conheça Nossa História",
                        fontSize = 26.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Assista ao vídeo e descubra como fazemos os melhores lanches da cidade!",
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
                                contentDescription = "Assistir vídeo",
                                tint = Color.White,
                                modifier = Modifier.size(40.dp)
                            )
                            Text("Vídeo Institucional", color = Color.White, fontWeight = FontWeight.Bold)
                            Text("Clique para assistir", color = Color.White.copy(alpha = 0.7f))
                        }
                    }
                }
            }
        }
    }
}
