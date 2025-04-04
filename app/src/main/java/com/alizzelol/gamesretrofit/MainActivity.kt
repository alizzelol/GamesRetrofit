package com.alizzelol.gamesretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.alizzelol.gamesretrofit.navigation.NavManager
import com.alizzelol.gamesretrofit.viewModel.GamesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //habilitar la inyección de dependencias
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel : GamesViewModel by viewModels()
        setContent {
            NavManager(viewModel)
        }
    }
}

