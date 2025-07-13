package com.dewa.kmtestone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dewa.kmtestone.ui.screens.AppNavigation
import com.dewa.kmtestone.ui.theme.KMTestOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KMTestOneTheme {
                AppNavigation()
            }
        }
    }
}