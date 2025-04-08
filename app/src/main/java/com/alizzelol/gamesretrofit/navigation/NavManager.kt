package com.alizzelol.gamesretrofit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alizzelol.gamesretrofit.viewModel.GamesViewModel
import com.alizzelol.gamesretrofit.views.DetailView
import com.alizzelol.gamesretrofit.views.HomeView
import com.alizzelol.gamesretrofit.views.SearchGameView

@Composable
fun NavManager(viewModel: GamesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home"){
            HomeView(viewModel, navController)
        }
        composable("DetailView/{id}/?{name}", arguments = listOf( //Pasar id como argument en la navegación
            navArgument("id"){ type = NavType.IntType},
            navArgument("name"){ type = NavType.StringType},
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val name = it.arguments?.getString("name") ?: ""
            DetailView(viewModel, navController, id, name)
        }
        composable("SearchGameView"){
            SearchGameView(viewModel, navController)
        }
    }
}