package com.snackparadise.data.model

import android.content.Context
import com.snackparadise.R

data class MenuItem(
    val id: Int,
    val imageUrl: String,
    val price: Double,
    val nameResId: Int,  // ID da string do nome
    val descriptionResId: Int? = null  // ID da string da descrição
) {
    // Funções auxiliares para pegar os textos localizados
    fun getName(context: Context): String = context.getString(nameResId)

    fun getDescription(context: Context): String? =
        descriptionResId?.let { context.getString(it) }
}