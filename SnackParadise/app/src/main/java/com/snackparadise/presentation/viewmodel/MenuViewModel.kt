package com.snackparadise.presentation.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.snackparadise.R
import com.snackparadise.data.model.MenuItem

class MenuViewModel(private val context: Context) : ViewModel() {

    val menuItems = mutableStateListOf<MenuItem>()

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        menuItems.clear()
        menuItems.addAll(getLocalizedMenuItems())
    }

    private fun getLocalizedMenuItems(): List<MenuItem> {
        return listOf(
            // Lanches
            MenuItem(
                id = 1,
                imageUrl = "Encomendar e Retirar (Tradicional)/Hamburguer 2 1.png",
                price = 28.00,
                nameResId = R.string.item_sunset_burger,
                descriptionResId = R.string.item_sunset_burger_desc
            ),
            MenuItem(
                id = 2,
                imageUrl = "Encomendar e Retirar (Tradicional)/Hamburguer 1 1.png",
                price = 27.00,
                nameResId = R.string.item_beach_burger,
                descriptionResId = R.string.item_beach_burger_desc
            ),
            MenuItem(
                id = 3,
                imageUrl = "Encomendar e Retirar (Tradicional)/Hamburguer 3 1.png",
                price = 26.00,
                nameResId = R.string.item_sun_beach_snack,
                descriptionResId = R.string.item_sun_beach_snack_desc
            ),
            MenuItem(
                id = 4,
                imageUrl = "Encomendar e Retirar (Vegano)/Hamburguer 1 1.png",
                price = 28.00,
                nameResId = R.string.item_palm_burger,
                descriptionResId = R.string.item_palm_burger_desc
            ),
            MenuItem(
                id = 5,
                imageUrl = "Encomendar e Retirar (Vegano)/Hamburguer 2 1.png",
                price = 26.00,
                nameResId = R.string.item_tropical_burger,
                descriptionResId = R.string.item_tropical_burger_desc
            ),
            MenuItem(
                id = 6,
                imageUrl = "Encomendar e Retirar (Vegano)/Hamburguer3 1.png",
                price = 26.50,
                nameResId = R.string.item_healthy_vacation,
                descriptionResId = R.string.item_healthy_vacation_desc
            ),

            // Acompanhamentos
            MenuItem(
                id = 7,
                imageUrl = "Acompanhamentos/Batata P.jpeg",
                price = 7.75,
                nameResId = R.string.item_fries_small
            ),
            MenuItem(
                id = 8,
                imageUrl = "Acompanhamentos/Batata M.jpeg",
                price = 8.25,
                nameResId = R.string.item_fries_medium
            ),
            MenuItem(
                id = 9,
                imageUrl = "Acompanhamentos/Batata G.jpeg",
                price = 8.99,
                nameResId = R.string.item_fries_large
            ),

            // Bebidas
            MenuItem(
                id = 10,
                imageUrl = "Bebidas/file (12).png",
                price = 5.50,
                nameResId = R.string.item_coca_cola
            ),
            MenuItem(
                id = 11,
                imageUrl = "Bebidas/file (11).png",
                price = 5.50,
                nameResId = R.string.item_pepsi
            ),
            MenuItem(
                id = 12,
                imageUrl = "Bebidas/file (13).png",
                price = 4.50,
                nameResId = R.string.item_guarana
            ),
            MenuItem(
                id = 13,
                imageUrl = "Bebidas/file (14).png",
                price = 4.20,
                nameResId = R.string.item_fanta_orange
            ),
            MenuItem(
                id = 14,
                imageUrl = "Bebidas/file (15).png",
                price = 4.00,
                nameResId = R.string.item_fanta_grape
            )
        )
    }
}