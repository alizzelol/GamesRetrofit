package com.alizzelol.gamesretrofit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alizzelol.gamesretrofit.model.GameList
import com.alizzelol.gamesretrofit.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel //inyección de dependencia de repo
class GamesViewModel @Inject constructor(private val repo: GamesRepository) : ViewModel(){

    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    init {
        fetchGames() //Conseguir juegos
    }

    private fun fetchGames(){
        viewModelScope.launch { //Ejecutar en segundo plano IO
            withContext(Dispatchers.IO){
                val result = repo.getGames()
                _games.value = result ?: emptyList() //Si no hay resultado, lista vacía
            }
        }
    }

}