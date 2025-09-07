package com.snackparadise.data.local

import android.content.Context

class AssetsRepository(private val context: Context) {
    fun loadFakeMenu(): List<String> {
        return listOf("Coxinha", "Pastel", "Suco")
    }
}