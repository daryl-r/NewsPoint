package com.daryl.newsviewer.api

import androidx.lifecycle.LiveData
import com.daryl.newsviewer.model.ArticlesResponse
import com.daryl.newsviewer.model.SourceResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * @author Daryl Richardson
 */
interface APIInterface {

    companion object {
        val NEWSAPI_URL = "https://newsapi.org/v1/"

        fun getNewsAPIService(): APIInterface {
            return Retrofit.Builder()
                .baseUrl(NEWSAPI_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(APIInterface::class.java)
        }
    }

    @GET("sources")
    fun getSources(
        @Query("language") language: String?,
        @Query("category") category: String?,
        @Query("country") country: String?
    ): LiveData<ApiResponse<SourceResponse>>

    @GET("articles")
    fun getArticles(
        @Query("source") source: String,
        @Query("sortBy") sortBy: String?,
        @Query("apiKey") apiKey: String
    ): Call<ArticlesResponse>
}