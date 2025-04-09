package com.alizzelol.gamesretrofit.repository

import com.alizzelol.gamesretrofit.data.ApiGames
import com.alizzelol.gamesretrofit.model.GameList
import com.alizzelol.gamesretrofit.model.GamesModel
import com.alizzelol.gamesretrofit.model.SingleGameModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames() : List<GameList>? {
        val response = apiGames.getGames()
        if(response.isSuccessful){
            return response.body()?.results
        }
        return null
    }

    suspend fun getGamesPaging(page : Int, pageSize : Int) : GamesModel{
        delay(3000L)
        //Para que carguen cada 3 segundos las siguientes páginas,
        // no deja hacer scroll hasta que hayan cargado
        return apiGames.getGamesPaging(page, pageSize)
    }

    suspend fun getGameById(id:Int):SingleGameModel?{
        val response = apiGames.getGameById(id)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

    suspend fun getGameByName(name : String):SingleGameModel?{
        val response = apiGames.getGameByName(name)
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }

}