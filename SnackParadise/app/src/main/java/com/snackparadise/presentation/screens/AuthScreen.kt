package com.snackparadise.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(navController: NavController) {
    AppScaffold(
        navController = navController,
        selectedItem = "Início"
    ) {
        var isLogin by remember { mutableStateOf(true) }
        val backgroundGradient = Brush.verticalGradient(
            colors = listOf(Color(0xFFCC0000), Color.Black)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundGradient),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color.White, shape = RoundedCornerShape(20.dp))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (isLogin) "Bem Vindo de Volta" else "Bem Vindo a Nosso App",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                // campos
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(15.dp))

                // botão principal
                Button(
                    onClick = { /* ação de login ou registro */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(
                        text = if (isLogin) "Entrar" else "Registrar-se",
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                // alternador login/registro
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { isLogin = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isLogin) Color.Red else Color.Gray
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Login")
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = { isLogin = false },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isLogin) Color.Red else Color.Gray
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Registro")
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // caixa sobre nós
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF7A0000), RoundedCornerShape(20.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Sobre Nós",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Texto texto texto texto",
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
