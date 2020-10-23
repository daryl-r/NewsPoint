package com.daryl.newsviewer.model

import com.google.gson.annotations.SerializedName


/**
 * @author Daryl Richardson
 */
data class ArticlesResponse(
    @SerializedName("status") var status: String?,
    @SerializedName("source") var source: String?,
    @SerializedName("sortBy") var sortBy: String?,
    @SerializedName("articles") var articles: List<Article>?
)

data class Article(
    @SerializedName("author") var author: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("url") var url: String?,
    @SerializedName("urlToImage") var urlToImage: String?,
    @SerializedName("publishedAt") var publishedAt: String?
)