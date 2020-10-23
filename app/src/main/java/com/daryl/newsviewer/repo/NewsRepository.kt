package com.daryl.newsviewer.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.daryl.newsviewer.BuildConfig
import com.daryl.newsviewer.RateLimiter
import com.daryl.newsviewer.api.ApiResponse
import com.daryl.newsviewer.api.NetworkBoundResource
import com.daryl.newsviewer.api.Resource
import com.daryl.newsviewer.db.NewsDBHelper
import com.daryl.newsviewer.db.SourceEntity
import java.util.concurrent.TimeUnit
import com.daryl.newsviewer.api.APIInterface
import com.daryl.newsviewer.model.ArticlesResponse
import com.daryl.newsviewer.model.SourceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * @author Daryl Richardson
 */
class NewsRepository(private val apiInterface: APIInterface) {

    val repoRateLimiter = RateLimiter<String>(10, TimeUnit.MINUTES)

    fun fetchNewsSource(
        context: Context,
        language: String?,
        category: String?,
        country: String?
    ): LiveData<Resource<List<SourceEntity>>> {
        return object : NetworkBoundResource<List<SourceEntity>, SourceResponse>() {
            override fun onFetchFailed() {
                repoRateLimiter.reset("all")
            }

            override fun saveCallResult(item: SourceResponse) {
                var sourceList = ArrayList<SourceEntity>()
                item.sources.forEach {
                    var sourceEntity = SourceEntity()
                    sourceEntity.id = it.id
                    sourceEntity.category = it.category
                    sourceEntity.country = it.country
                    sourceEntity.description = it.description
                    sourceEntity.language = it.language
                    sourceEntity.name = it.name
                    sourceEntity.url = it.url
                    sourceList.add(sourceEntity)
                }
                NewsDBHelper.getInstance(context).getSourceDao().insertSources(sourceList)
            }

            override fun shouldFetch(data: List<SourceEntity>?): Boolean = repoRateLimiter.shouldFetch("all")

            override fun loadFromDb(): LiveData<List<SourceEntity>> {
                return NewsDBHelper.getInstance(context).getSourceDao().getAllNewsSource()
            }

            override fun createCall(): LiveData<ApiResponse<SourceResponse>> {
                return apiInterface.getSources(language, category, country)
            }
        }.asLiveData()
    }

    fun getNewsArticles(source: String, sortBy: String?): LiveData<ArticlesResponse> {
        val liveDataArticlesResponse: MutableLiveData<ArticlesResponse> = MutableLiveData()
        apiInterface.getArticles(source, sortBy, BuildConfig.API_KEY).enqueue(object : Callback<ArticlesResponse> {
            override fun onFailure(call: Call<ArticlesResponse>?, t: Throwable?) {
                Log.e("Oops", "Network error ${t?.message}")
            }

            override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>) {
                Log.e("Article Call Status", "${response.body()?.status}")
                Log.e("Article Call List Contains", "${response.body()?.articles?.size}")
                liveDataArticlesResponse.value = response.body()
            }
        })
        return liveDataArticlesResponse
    }
}