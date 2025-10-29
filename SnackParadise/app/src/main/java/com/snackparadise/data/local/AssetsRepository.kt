package com.snackparadise.data.local

import android.content.Context
import com.google.gson.Gson
import com.snackparadise.R
import com.snackparadise.data.model.MenuItem
import java.io.InputStreamReader

class AssetsRepository(private val context: Context) {

    fun loadMenu(): List<MenuItem> {
        val inputStream = context.assets.open("menu.json")
        val reader = InputStreamReader(inputStream)

        val data = Gson().fromJson(reader, MenuJson::class.java)
        reader.close()

        // junta todas as categorias em uma lista só (COM LOCALIZAÇÃO)
        return buildList {
            addAll(data.lanches.map {
                it.toMenuItem(context.getString(R.string.category_burgers), context)
            })
            addAll(data.acompanhamentos.map {
                it.toMenuItem(context.getString(R.string.category_sides), context)
            })
            addAll(data.bebidas.map {
                it.toMenuItem(context.getString(R.string.category_drinks), context)
            })
        }
    }

    // classes de suporte pro Gson ler o JSON
    private data class MenuJson(
        val lanches: List<ItemJson>,
        val acompanhamentos: List<ItemJson>,
        val bebidas: List<ItemJson>
    )

    private data class ItemJson(
        val id: Int,
        val nome: String,
        val img: String,
        val preco: Double,
        val descricao: String? = null
    ) {
        fun toMenuItem(category: String, context: Context): MenuItem {
            return MenuItem(
                id = id,
                imageUrl = img,
                price = preco,
                nameResId = getStringResIdByName(context, nome),
                descriptionResId = descricao?.let { getStringResIdByName(context, it) }
            )
        }

        private fun getStringResIdByName(context: Context, name: String): Int {
            val resourceName = name
                .lowercase()
                .replace(" ", "_")
                .replace(Regex("[^a-z0-9_]"), "") // remove acentos e símbolos
            val resId = context.resources.getIdentifier(resourceName, "string", context.packageName)
            return if (resId != 0) resId else R.string.item_unknown
        }
    }
}
