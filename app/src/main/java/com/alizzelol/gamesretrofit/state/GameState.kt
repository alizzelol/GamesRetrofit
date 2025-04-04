package com.alizzelol.gamesretrofit.state

data class GameState( //valores que utilizamos en las vistas
    val name : String = "",
    val description_raw : String = "",
    val metacritic : Int = 0,
    val website: String = "",
    val background_image : String = ""
)

