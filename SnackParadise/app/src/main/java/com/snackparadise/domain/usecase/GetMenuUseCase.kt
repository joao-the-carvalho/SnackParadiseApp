package com.snackparadise.domain.usecase

import com.snackparadise.data.model.MenuItem
import com.snackparadise.domain.repository.MenuRepository

class GetMenuUseCase(private val repo: MenuRepository) {
    suspend operator fun invoke(): List<MenuItem> = repo.getMenu()
}