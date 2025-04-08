package com.alizzelol.gamesretrofit.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alizzelol.gamesretrofit.components.CardGame
import com.alizzelol.gamesretrofit.components.MainTopBar
import com.alizzelol.gamesretrofit.util.Constants.Companion.CUSTOM_BLACK
import com.alizzelol.gamesretrofit.viewModel.GamesViewModel

@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController){
    Scaffold (
        topBar = { //Barra arriba de la Activity
            MainTopBar(title = "API GAMES", onClickBackButton = {}) {
                navController.navigate("SearchGameView")
            }
        }
    ) {
        ContentHomeView(viewModel, it, navController)
    }

}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, pad:PaddingValues, navController: NavController){
    val games by viewModel.games.collectAsState()
    var search by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(pad),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        TextField(value = search,  //TextField Search para buscar
            onValueChange = {search = it},
            label = { Text(text = "Search")},
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {

                }
            ),
            modifier = Modifier.fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
        )

        LazyColumn (
            modifier = Modifier
                .background(Color(CUSTOM_BLACK))
        ) {
            items(games){ item ->
                CardGame(item) {
                    navController.navigate("DetailView/${item.id}") //llevar id del item
                }
                Text(text = item.name,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}
