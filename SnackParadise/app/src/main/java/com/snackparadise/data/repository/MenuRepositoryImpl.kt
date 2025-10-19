package com.snackparadise.data.repository

import com.snackparadise.data.local.AssetsRepository
import com.snackparadise.data.model.MenuItem
import com.snackparadise.domain.repository.MenuRepository

class MenuRepositoryImpl(
    private val assetsRepository: AssetsRepository
) : MenuRepository {

    // pega todos os itens do menu
    override suspend fun getMenu(): List<MenuItem> {
        return assetsRepository.loadMenu()
    }

    // filtra por categoria
    override suspend fun getMenuByCategory(category: String): List<MenuItem> {
        return getMenu().filter { it.category.equals(category, ignoreCase = true) }
    }

    // pega todas as categorias únicas
    override suspend fun getCategories(): List<String> {
        return getMenu().map { it.category }.distinct()
    }
}
