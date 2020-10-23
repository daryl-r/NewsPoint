package com.daryl.newsviewer.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.daryl.newsviewer.api.Resource
import com.daryl.newsviewer.db.SourceEntity
import com.daryl.newsviewer.api.APIInterface
import com.daryl.newsviewer.model.ArticlesResponse
import com.daryl.newsviewer.repo.NewsRepository

/**
 * @author Daryl Richardson
 */
class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val newsRepo : NewsRepository = NewsRepository(APIInterface.getNewsAPIService())
    private val context: Context = application.applicationContext

    fun getNewsSource(language: String?, category: String?, country: String?): LiveData<Resource<List<SourceEntity>>> {
        return newsRepo.fetchNewsSource(context,language, category, country)
    }

    fun getNewsArticles(source: String, sortBy: String?) : LiveData<ArticlesResponse> {
        return newsRepo.getNewsArticles(source, sortBy)
    }
}