package com.snackparadise.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.snackparadise.presentation.components.AppScaffold
import kotlinx.coroutines.delay
import coil.compose.rememberAsyncImagePainter

// --- NOVO COMPOSABLE PARA O CARROSSEL SLIDER ---

@Composable
fun ImageCarousel(imageList: List<String>) {
    // Estado para rastrear o índice da imagem atual
    var currentIndex by remember { mutableIntStateOf(0) }

    // Efeito para alternar as imagens a cada 2 segundos
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000) // Espera 2 segundos
            // Avança para a próxima imagem. O '%' (módulo) garante que o índice volte a zero.
            currentIndex = (currentIndex + 1) % imageList.size
        }
    }

    // Renderização da Imagem
    val currentImageName = imageList[currentIndex]

    Box(
        modifier = Modifier
            .fillMaxWidth()
            // AUMENTANDO A ALTURA DO CARROSSEL
            .height(250.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF9F0605)),
        contentAlignment = Alignment.Center
    ) {
        // Carrega a imagem do asset
        Image(
            painter = rememberAsyncImagePainter("file:///android_asset/$currentImageName"),
            contentDescription = "Imagem rotativa sobre o Snack Paradise",
            // ALTERANDO PARA ContentScale.Fit para garantir que a imagem inteira caiba
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(navController: NavController) {
    // ----------------------------------------------------
    // INÍCIO DA LÓGICA DA BARRA DE STATUS
    // ----------------------------------------------------
    // 1. Obtém o controlador da UI do sistema
    val systemUiController = rememberSystemUiController()
    // A cor vermelha escura que se harmoniza com o gradiente
    val statusBarColor = Color(0xFF880000)

    // 2. Aplica a cor da barra de status quando a tela é composta
    DisposableEffect(systemUiController) {
        // Define a cor da barra de status
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            // Altera o esquema de cores dos ícones (ícones claros/escuros).
            // Como a cor é escura, deixamos os ícones (texto, bateria) brancos (false)
            darkIcons = false
        )
        // Limpeza: Restaura a cor padrão (opcional, mas boa prática)
        onDispose {
            // Pode restaurar a cor padrão ou a cor do tema
            systemUiController.setStatusBarColor(
                color = Color.Black, // Exemplo: volta para preto
                darkIcons = false
            )
        }
    }
    // ----------------------------------------------------
    // FIM DA LÓGICA DA BARRA DE STATUS
    // ----------------------------------------------------
    
    var isLogin by remember { mutableStateOf(true) }

    // Estados para os campos de texto
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFCC0000), Color.Black)
    )

    // Lista de nomes de arquivos de imagem (1.png, 2.png, 3.png)
    val carouselImages = remember { listOf("1.png", "2.png", "3.png") }


    AppScaffold(
        navController = navController,
        selectedItem = "Login/Registro"
    ) {
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

                // Campos de texto para login/registro
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Botão principal
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

                // Alternador login/registro
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

                // --- CARROSSEL SLIDER INSERIDO AQUI ---
                ImageCarousel(imageList = carouselImages)
            }
        }
    }
}
