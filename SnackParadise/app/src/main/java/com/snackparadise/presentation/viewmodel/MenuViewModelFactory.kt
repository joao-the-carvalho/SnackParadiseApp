package com.snackparadise.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.snackparadise.data.local.AssetsRepository
import com.snackparadise.data.repository.MenuRepositoryImpl

class MenuViewModelFactory(private val context: MenuRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val assetsRepo = AssetsRepository(context)
        val repo = MenuRepositoryImpl(assetsRepo)
        return MenuViewModel(repo) as T
    }
}
