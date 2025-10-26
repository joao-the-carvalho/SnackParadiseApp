package com.snackparadise.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.snackparadise.data.model.MenuItem
import com.snackparadise.presentation.components.AppScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen(
    navController: NavController,
    cartItems: List<MenuItem> // itens selecionados do menu
) {
    AppScaffold(navController = navController, selectedItem = "Pontos") {
        var name by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var number by remember { mutableStateOf("") }
        var complement by remember { mutableStateOf("") }

        // dropdown states
        var atendimentoExpanded by remember { mutableStateOf(false) }
        var pagamentoExpanded by remember { mutableStateOf(false) }

        var atendimentoSelecionado by remember { mutableStateOf("Sim") }
        var pagamentoSelecionado by remember { mutableStateOf("Débito") }

        val atendimentoOptions = listOf("Sim", "Não")
        val pagamentoOptions = listOf("Débito", "Crédito", "Pix", "Dinheiro")

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFDD0000), Color(0xFF880000))
                    )
                )
                .padding(16.dp)
        ) {
            // Itens selecionados
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "ITENS SELECIONADOS",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    cartItems.forEach { item ->
                        Text(
                            text = "- ${item.name} (x1) - R$ ${item.price}",
                            color = Color.Black
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Pagamento e dados
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "PAGAMENTO",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Nome") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = address,
                        onValueChange = { address = it },
                        label = { Text("Endereço") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = number,
                        onValueChange = { number = it },
                        label = { Text("Número") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = complement,
                        onValueChange = { complement = it },
                        label = { Text("Complemento") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // dropdowns
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        // Atendimento Preferencial
                        ExposedDropdownMenuBox(
                            expanded = atendimentoExpanded,
                            onExpandedChange = { atendimentoExpanded = !atendimentoExpanded },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = atendimentoSelecionado,
                                onValueChange = { },
                                readOnly = true,
                                label = { Text("Atendimento Preferencial") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = atendimentoExpanded) },
                                modifier = Modifier.fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = atendimentoExpanded,
                                onDismissRequest = { atendimentoExpanded = false }
                            ) {
                                atendimentoOptions.forEach { selectionOption ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOption) },
                                        onClick = {
                                            atendimentoSelecionado = selectionOption
                                            atendimentoExpanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        // Forma de Pagamento
                        ExposedDropdownMenuBox(
                            expanded = pagamentoExpanded,
                            onExpandedChange = { pagamentoExpanded = !pagamentoExpanded },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = pagamentoSelecionado,
                                onValueChange = { },
                                readOnly = true,
                                label = { Text("Forma de Pagamento") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = pagamentoExpanded) },
                                modifier = Modifier.fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = pagamentoExpanded,
                                onDismissRequest = { pagamentoExpanded = false }
                            ) {
                                pagamentoOptions.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option) },
                                        onClick = {
                                            pagamentoSelecionado = option
                                            pagamentoExpanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            // ação de finalizar pedido
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFFB00000)),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text("Finalizar Pedido")
                    }
                }
            }
        }
    }
}
