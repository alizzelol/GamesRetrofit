package com.alizzelol.gamesretrofit.model

data class GamesModel( //datos a recuperar

    val count : Int,
    val results : List<GameList>

)

data class GameList(
    val id : Int,
    val name : String,
    val background_image : String
)

