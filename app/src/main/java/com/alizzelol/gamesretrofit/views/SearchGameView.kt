package com.alizzelol.gamesretrofit.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.alizzelol.gamesretrofit.viewModel.GamesViewModel

@Composable
fun SearchGameView(viewModel: GamesViewModel, navController: NavController){
    Text(text= "Search", color = Color.White)
}