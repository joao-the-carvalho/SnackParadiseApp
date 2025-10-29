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
import androidx.compose.ui.res.stringResource
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
                        text = stringResource(R.string.about_title),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color(0xFF8B0000)
                    )
                    Text(
                        text = stringResource(R.string.about_subtitle),
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
                        text = stringResource(R.string.about_our_story),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color(0xFF8B0000)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.about_story_text1),
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.about_story_text2),
                        textAlign = TextAlign.Center
                    )
                }
            }

            // seção: valores
            Text(
                text = stringResource(R.string.about_our_values),
                color = Color(0xFF8B0000),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                ValorCard(
                    emoji = "🤝",
                    titulo = stringResource(R.string.value_integrity),
                    desc = stringResource(R.string.value_integrity_desc)
                )
                ValorCard(
                    emoji = "❤️",
                    titulo = stringResource(R.string.value_respect),
                    desc = stringResource(R.string.value_respect_desc)
                )
                ValorCard(
                    emoji = "💡",
                    titulo = stringResource(R.string.value_innovation),
                    desc = stringResource(R.string.value_innovation_desc)
                )
                ValorCard(
                    emoji = "⭐",
                    titulo = stringResource(R.string.value_inclusivity),
                    desc = stringResource(R.string.value_inclusivity_desc)
                )
                ValorCard(
                    emoji = "🎯",
                    titulo = stringResource(R.string.value_quality),
                    desc = stringResource(R.string.value_quality_desc)
                )
                ValorCard(
                    emoji = "🌱",
                    titulo = stringResource(R.string.value_growth),
                    desc = stringResource(R.string.value_growth_desc)
                )
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
                        text = stringResource(R.string.about_mission_title),
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF8B0000),
                        fontSize = 20.sp
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.about_mission_text),
                        textAlign = TextAlign.Center
                    )
                }
            }

            // seção: números
            Text(
                text = stringResource(R.string.about_in_numbers),
                color = Color(0xFF8B0000),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                NumeroCard(
                    valor = stringResource(R.string.about_founded_year),
                    descricao = stringResource(R.string.about_founded_label)
                )
                NumeroCard(
                    valor = stringResource(R.string.about_satisfaction),
                    descricao = stringResource(R.string.about_satisfaction_label)
                )
                NumeroCard(
                    valor = stringResource(R.string.about_hours),
                    descricao = stringResource(R.string.about_hours_label)
                )
                NumeroCard(
                    valor = stringResource(R.string.about_rating),
                    descricao = stringResource(R.string.about_rating_label)
                )
            }

            Spacer(Modifier.height(16.dp))
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