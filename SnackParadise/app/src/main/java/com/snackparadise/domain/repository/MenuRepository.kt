package com.snackparadise.domain.repository

import com.snackparadise.data.model.MenuItem

interface MenuRepository {
    suspend fun getMenu(): List<MenuItem>
    suspend fun getMenuByCategory(category: String): List<MenuItem>
    suspend fun getCategories(): List<String>
}