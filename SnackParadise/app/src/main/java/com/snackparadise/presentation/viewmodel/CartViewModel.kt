package com.snackparadise.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.snackparadise.data.model.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.collections.toMutableList

// Exemplo de como seria seu ViewModel de carrinho
class CartViewModel : ViewModel() {
    // Inicialize com uma lista vazia, ou carregue do banco de dados/repositório
    private val _cartItems = MutableStateFlow<List<MenuItem>>(emptyList())
    val cartItems: StateFlow<List<MenuItem>> = _cartItems

    // Exemplo de função para adicionar um item (opcional)
    fun addItemToCart(item: MenuItem) {
        val currentList = _cartItems.value.toMutableList()
        currentList.add(item)
        _cartItems.value = currentList.toList()
    }
}