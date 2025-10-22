package com.snackparadise.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snackparadise.data.model.MenuItem
import com.snackparadise.data.repository.MenuRepositoryImpl
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MenuViewModel(
    private val repository: MenuRepositoryImpl
) : ViewModel() {

    var menuItems by mutableStateOf<List<MenuItem>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            menuItems = repository.getMenu()
        }
    }
}
