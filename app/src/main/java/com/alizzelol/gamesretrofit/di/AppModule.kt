package com.alizzelol.gamesretrofit.di

import com.alizzelol.gamesretrofit.data.ApiGames
import com.alizzelol.gamesretrofit.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides //configuración de retrofit
    fun providesRetrofit(): Retrofit { //función de retrofit
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiGames(retrofit: Retrofit) : ApiGames {
        return retrofit.create(ApiGames::class.java)
    }

}
