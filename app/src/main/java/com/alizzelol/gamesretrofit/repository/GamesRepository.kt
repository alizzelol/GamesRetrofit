package com.alizzelol.gamesretrofit.repository

import com.alizzelol.gamesretrofit.data.ApiGames
import com.alizzelol.gamesretrofit.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames() : List<GameList>? {
        val response = apiGames.getGames()
        if(response.isSuccessful){
            return response.body()?.results
        }
        return null
    }
}