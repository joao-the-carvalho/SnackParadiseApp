package com.snackparadise.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.snackparadise.data.model.MenuItem
import java.io.InputStreamReader

class AssetsRepository(private val context: Context) {

    fun loadMenu(): List<MenuItem> {
        val inputStream = context.assets.open("menu.json")
        val reader = InputStreamReader(inputStream)

        val data = Gson().fromJson(reader, MenuJson::class.java)
        reader.close()

        // junta todas as categorias em uma lista só
        return buildList {
            addAll(data.lanches.map { it.toMenuItem("Lanches") })
            addAll(data.acompanhamentos.map { it.toMenuItem("Acompanhamentos") })
            addAll(data.bebidas.map { it.toMenuItem("Bebidas") })
        }
    }

    // classes de suporte pro Gson ler o JSON
    data class MenuJson(
        val lanches: List<ItemJson>,
        val acompanhamentos: List<ItemJson>,
        val bebidas: List<ItemJson>
    )

    data class ItemJson(
        val id: Int,
        val nome: String,
        val img: String,
        val preco: Double,
        val descricao: String? = null
    ) {
        fun toMenuItem(category: String): MenuItem {
            return MenuItem(
                id = id,
                name = nome,
                description = descricao ?: "",
                price = preco,
                category = category,
                imageUrl = img
            )
        }
    }
}
