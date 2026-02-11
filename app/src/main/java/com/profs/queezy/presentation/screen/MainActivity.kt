package com.profs.queezy.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.presentation.navigation.NavigationGraph
import com.profs.queezy.presentation.theme.QueezyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            QueezyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    NavigationGraph(navController, Modifier.padding(paddingValues))
                }
            }
        }
    }
}