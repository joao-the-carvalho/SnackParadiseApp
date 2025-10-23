package com.snackparadise.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.snackparadise.R
import kotlinx.coroutines.launch
import androidx.compose.foundation.border
import com.snackparadise.presentation.components.AppScaffold

@Composable
fun SobreScreen(navController: NavController) {
    AppScaffold(
        navController = navController,
        title = "Sobre nós",
        selectedItem = "Sobre nós"
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFC107))
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Conheça a SnackParadise",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color(0xFF8B0000)
                    )
                    Text(
                        text = "Sabor, qualidade e inovação desde 2024",
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    Image(
                        painter = painterResource(id = R.drawable.asd),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                }
            }

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Nossa História",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color(0xFF8B0000)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Somos a Snack Paradise ou SP, um restaurante que busca primariamente o sabor, o fácil acesso e a memorabilidade em nossas receitas!",
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Sendo oficialmente fundada em 2024, o projeto nasceu de um trabalho do curso de Desenvolvimento de Sistemas.",
                        textAlign = TextAlign.Center
                    )
                }
            }

            // seção: valores
            Text(
                text = "Nossos Valores",
                color = Color(0xFF8B0000),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                ValorCard("🤝", "Integridade", "Transparência e honestidade em cada interação")
                ValorCard("❤️", "Respeito", "Valorização de funcionários, clientes e parceiros")
                ValorCard("💡", "Inovação", "Busca constante por soluções gastronômicas únicas")
                ValorCard("⭐", "Inclusividade", "Ambiente acolhedor e acessível para todos")
                ValorCard("🎯", "Qualidade", "Compromisso com a excelência em cada produto")
                ValorCard("🌱", "Crescimento", "Evolução contínua com responsabilidade social")
            }

            // seção: missão
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🎯 Missão",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF8B0000),
                        fontSize = 20.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Proporcionar experiências gastronômicas memoráveis com sabores únicos, qualidade e tecnologia inovadora.",
                        textAlign = TextAlign.Center
                    )
                }
            }

            // seção: números
            Text(
                text = "SnackParadise em Números",
                color = Color(0xFF8B0000),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                NumeroCard("2024", "Ano de Fundação")
                NumeroCard("100", "% Satisfação")
                NumeroCard("6", "Horas de Atendimento")
                NumeroCard("5", "Estrelas de Avaliação")
            }

            Spacer(Modifier.height(16.dp))

            // CTA final
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB71C1C)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Faça Parte da Nossa História",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Junte-se a nós e descubra por que SnackParadise é mais que um restaurante!",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = { /* TODO abrir cardápio */ }) {
                        Text("Ver Cardápio")
                    }
                    OutlinedButton(
                        onClick = { /* TODO fazer pedido */ },
                        border = BorderStroke(1.dp, Color.White),
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text("Fazer Pedido", color = Color.White)
                    }
                }
            }

            Spacer(Modifier.height(40.dp))
        }
    }
}

@Composable
fun ValorCard(emoji: String, titulo: String, desc: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(emoji, fontSize = 26.sp)
            Text(titulo, color = Color(0xFF8B0000), fontWeight = FontWeight.Bold)
            Text(desc, textAlign = TextAlign.Center, color = Color.Gray)
        }
    }
}

@Composable
fun NumeroCard(valor: String, descricao: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(valor, fontWeight = FontWeight.Bold, fontSize = 26.sp, color = Color(0xFF8B0000))
            Text(descricao, color = Color.Gray)
        }
    }
}
