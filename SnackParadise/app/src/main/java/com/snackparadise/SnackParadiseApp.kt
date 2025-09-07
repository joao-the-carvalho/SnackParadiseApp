package com.snackparadise

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.snackparadise.presentation.nav.NavGraph

@Composable
fun SnackParadiseApp() {
    MaterialTheme {
        Surface {
            NavGraph()
        }
    }
}