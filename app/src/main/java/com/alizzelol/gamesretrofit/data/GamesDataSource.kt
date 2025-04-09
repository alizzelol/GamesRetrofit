package com.alizzelol.gamesretrofit.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alizzelol.gamesretrofit.model.GameList
import com.alizzelol.gamesretrofit.repository.GamesRepository

//Página principal de la paginación
class GamesDataSource (private val repo:GamesRepository) : PagingSource<Int, GameList>(){ //tipo de dato y de donde obtenerlo

    //Dos métodos obtenidos por :PagingSource
    override fun getRefreshKey(state: PagingState<Int, GameList>): Int? { //Estado de la paginación
        return state.anchorPosition.let { anchorPosition ->
            val anchorPage = anchorPosition?.let { state.closestPageToPosition(it) }
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameList> { //Se encarga de cargar los juegos en la página
        return try{
            val nextPageNumber = params.key ?: 1
            val response = repo.getGamesPaging(nextPageNumber, 3)
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = if(response.results.isNotEmpty()) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}