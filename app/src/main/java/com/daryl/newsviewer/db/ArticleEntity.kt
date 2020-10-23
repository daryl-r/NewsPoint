package com.daryl.newsviewer.db

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daryl.newsviewer.NewsConstants

/**
 * @author Daryl Richardson
 */
@Entity(tableName = NewsConstants.T_ARTICLE)
data class ArticleEntity(
        @PrimaryKey @NonNull
        var title: String = "",
        var source: String? = "",
        var author: String? = "",
        var description: String? = "",
        var url: String? = "",
        var urlToImage: String? = "",
        var publishedAt: String? = ""
)