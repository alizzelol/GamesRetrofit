package com.alizzelol.gamesretrofit.data

import com.alizzelol.gamesretrofit.model.GamesModel
import com.alizzelol.gamesretrofit.util.Constants.Companion.API_KEY
import com.alizzelol.gamesretrofit.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {

    @GET(ENDPOINT + API_KEY) //conseguir datos de GamesModel
    suspend fun getGames(): Response<GamesModel>
}