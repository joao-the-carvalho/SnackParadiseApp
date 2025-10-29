package com.snackparadise.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.snackparadise.R
import com.snackparadise.presentation.components.AppScaffold

@Composable
fun ProfileScreen(navController: NavController) {
    AppScaffold(navController = navController, selectedItem = "Perfil") {
        val scroll = rememberScrollState()
        val gradient = Brush.verticalGradient(
            colors = listOf(Color(0xFF000000), Color(0xFF220000), Color(0xFF000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .verticalScroll(scroll)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Cabeçalho com título
            Text(
                text = stringResource(R.string.my_profile),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Foto de perfil
            ProfilePhotoSection()

            Spacer(modifier = Modifier.height(8.dp))

            // Informações Pessoais
            ProfileCard(
                title = stringResource(R.string.personal_info),
                icon = Icons.Default.Person
            ) {
                OutlinedField(
                    label = stringResource(R.string.username),
                    value = "john"
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.email_label),
                    value = "john@gmail.com"
                )
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = { /* editar */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB00000)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Edit, contentDescription = null, tint = Color.White)
                    Spacer(Modifier.width(8.dp))
                    Text(stringResource(R.string.edit), color = Color.White)
                }
            }

            // Endereço de Entrega
            ProfileCard(
                title = stringResource(R.string.delivery_address),
                icon = Icons.Default.Place
            ) {
                OutlinedField(
                    label = stringResource(R.string.zip_code),
                    value = ""
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.address),
                    value = ""
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.number),
                    value = ""
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.neighborhood),
                    value = ""
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.city),
                    value = ""
                )
            }

            // Segurança
            ProfileCard(
                title = stringResource(R.string.security),
                icon = Icons.Default.Lock
            ) {
                OutlinedField(
                    label = stringResource(R.string.current_password),
                    value = "",
                    isPassword = true
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.new_password),
                    value = "",
                    isPassword = true
                )
                Spacer(Modifier.height(12.dp))
                OutlinedField(
                    label = stringResource(R.string.confirm_password),
                    value = "",
                    isPassword = true
                )
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = { /* alterar senha */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB00000)
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.change_password), color = Color.White)
                }
            }

            // Meus Pedidos
            ProfileCard(
                title = stringResource(R.string.my_orders),
                icon = painterResource(id = R.drawable.history)
            ) {
                Text(
                    stringResource(R.string.no_orders),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            // Acompanhar Entrega
            ProfileCard(
                title = stringResource(R.string.track_delivery),
                icon = painterResource(id = R.drawable.lco)
            ) {
                Text(
                    stringResource(R.string.no_delivery),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProfilePhotoSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111111), RoundedCornerShape(20.dp))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        colors = listOf(Color(0xFFD50000), Color(0xFF8B0000))
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(70.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* alterar foto */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB00000)
            ),
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                stringResource(R.string.change_photo),
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun ProfileCard(
    title: String,
    icon: Any,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF111111)
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                when (icon) {
                    is ImageVector -> Icon(
                        icon,
                        contentDescription = null,
                        tint = Color(0xFFB00000),
                        modifier = Modifier.size(28.dp)
                    )
                    is Painter -> Icon(
                        painter = icon,
                        contentDescription = null,
                        tint = Color(0xFFB00000),
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            content()
        }
    }
}

@Composable
fun OutlinedField(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            label,
            color = Color(0xFFFFC107),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = {},
            visualTransformation = if (isPassword)
                PasswordVisualTransformation()
            else
                androidx.compose.ui.text.input.VisualTransformation.None,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFB00000),
                unfocusedBorderColor = Color(0xFF444444),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color(0xFFB00000)
            ),
            shape = RoundedCornerShape(12.dp)
        )
    }
}