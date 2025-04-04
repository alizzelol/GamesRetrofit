package com.alizzelol.gamesretrofit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //añadir inyección de dependencias
class GameApplication : Application() {
}