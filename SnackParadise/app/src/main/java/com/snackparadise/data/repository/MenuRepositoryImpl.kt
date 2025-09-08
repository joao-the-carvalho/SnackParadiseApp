package com.snackparadise.data.repository

import com.snackparadise.data.local.AssetsRepository
import com.snackparadise.data.model.MenuItem
import com.snackparadise.domain.repository.MenuRepository

class MenuRepositoryImpl(
    private val assetsRepository: AssetsRepository
) : MenuRepository {

    override suspend fun getMenu(): List<MenuItem> {
        return listOf(

        )
    }
}
