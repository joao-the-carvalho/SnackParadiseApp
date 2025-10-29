package com.snackparadise.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.snackparadise.presentation.components.AppScaffold
import androidx.compose.ui.res.stringResource
import com.snackparadise.R

@Composable
fun PontosScreen(navController: NavController) {
    AppScaffold(navController = navController, selectedItem = "Pontos") {
        val nivelAtual = "Bronze"
        val pontos = 0

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Text(
                    stringResource(R.string.points_program),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB00000),
                    textAlign = TextAlign.Center
                )
                Text(
                    stringResource(R.string.points_description),
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
                )
            }

            // CARD DE PONTOS E NÍVEL
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(stringResource(R.string.your_points), fontWeight = FontWeight.Medium)
                            Text(
                                "$pontos",
                                fontWeight = FontWeight.Bold,
                                fontSize = 32.sp,
                                color = Color(0xFFB00000)
                            )
                            Button(
                                onClick = { /* TODO: simular gastos */ },
                                colors = ButtonDefaults.buttonColors(Color(0xFFB00000)),
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                Text(stringResource(R.string.simulate_spend), color = Color.White)
                            }
                        }
                    }

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(stringResource(R.string.your_level), fontWeight = FontWeight.Medium)
                            Text(
                                nivelAtual,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                                color = Color(0xFFB00000)
                            )
                            Text(stringResource(R.string.silver_in), color = Color.Gray, fontSize = 12.sp)
                        }
                    }
                }
            }

            // NÍVEIS DE FIDELIDADE
            item {
                Text(
                    stringResource(R.string.loyalty_levels),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB00000),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            val niveis = listOf(
                Nivel("\uD83E\uDD49 Bronze", "0 - 249 pontos", listOf("Desconto de 5% acima de R$30", "Ofertas especiais")),
                Nivel("\uD83E\uDD48 Prata", "250 - 499 pontos", listOf("10% desconto acima de R$25", "Frete grátis acima de R$40")),
                Nivel("\uD83E\uDD47 Ouro", "500 - 999 pontos", listOf("15% desconto", "Frete grátis", "Atendimento prioritário")),
                Nivel("\uD83D\uDC8E Diamante", "1000+ pontos", listOf("20% desconto", "Cardápio VIP", "Suporte 24/7"))
            )

            items(niveis) { nivel ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            nivel.nome,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB00000)
                        )
                        Text(nivel.intervalo, color = Color.Gray, fontSize = 13.sp)
                        Spacer(Modifier.height(8.dp))
                        nivel.beneficios.forEach { beneficio ->
                            Text("✓ $beneficio", fontSize = 13.sp)
                        }
                    }
                }
            }

            // TROQUE SEUS PONTOS
            item {
                Text(
                    "Troque Seus Pontos",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB00000),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            val recompensas = listOf(
                Recompensa("\uD83C\uDF54 Hambúrguer Clássico", 150),
                Recompensa("\uD83C\uDF5F Batata Frita Grande", 80),
                Recompensa("\uD83E\uDD64 Refrigerante 500ml", 60),
                Recompensa("\uD83C\uDF5F\uD83C\uDF54 Combo Simples", 200),
                Recompensa("\uD83C\uDF70 Sobremesa Especial", 120),
                Recompensa("\uD83C\uDF81 Combo Família", 500)
            )

            items(recompensas) { r ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(r.nome, fontWeight = FontWeight.Medium)
                            Text("${r.pontos} pontos", color = Color(0xFFB00000))
                        }
                        Button(
                            onClick = { /* trocar */ },
                            colors = ButtonDefaults.buttonColors(Color(0xFFFFE066))
                        ) {
                            Text("Trocar", color = Color.Black)
                        }
                    }
                }
            }

            // HISTÓRICO DE PONTOS
            item {
                Text(
                    "Histórico de Pontos",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB00000),
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color(0xFFB00000))
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Data", color = Color.White)
                        Text("Descrição", color = Color.White)
                        Text("Pontos", color = Color.White)
                        Text("Saldo", color = Color.White)
                    }
                }
            }
        }
    }
}

data class Nivel(val nome: String, val intervalo: String, val beneficios: List<String>)
data class Recompensa(val nome: String, val pontos: Int)
