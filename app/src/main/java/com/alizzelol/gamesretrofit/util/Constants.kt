package com.alizzelol.gamesretrofit.util

class Constants { //para guardar constantes que usar en el proyecto

    companion object{ //detalles de la API rawg
        const val BASE_URL = "https://api.rawg.io/api/"
        const val ENDPOINT = "games"
        const val API_KEY = "?key=833f198f41ac48a0b60636b697352d79"
        const val CUSTOM_BLACK = 0xFF2B2626 //Añadir color por defecto, al ser constant
    }
}

//https://api.rawg.io/api/games?key=833f198f41ac48a0b60636b697352d79
//https://api.rawg.io/api/games/1223?key=833f198f41ac48a0b60636b697352d79
// 1223 sería el id del juego para elegir uno solo