package com.manishjajoriya.kabar.data.remote

import com.manishjajoriya.kabar.data.remote.dto.NewsResponse
import com.manishjajoriya.kabar.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

  @GET
  suspend fun getNews(
    @Query("page") page: Int,
    @Query("sources") source: String,
    @Query("apiKey") apiKey: String = API_KEY,
  ): NewsResponse
}
