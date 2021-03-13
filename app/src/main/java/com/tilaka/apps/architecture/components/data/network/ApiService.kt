package com.tilaka.apps.architecture.components.data.network

import CharacterResponseModel
import com.tilaka.apps.architecture.components.data.model.SearchResultModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("manga/1/characters")
    suspend fun getCharacters(): CharacterResponseModel


    @GET("search/anime")
    suspend fun getListAnimes(@Query("q") searchParam: String): SearchResultModel


}