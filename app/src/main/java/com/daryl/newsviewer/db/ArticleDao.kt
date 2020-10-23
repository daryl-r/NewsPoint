package com.daryl.newsviewer.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * @author Daryl Richardson
 */
@Dao
interface ArticleDao {

    @Query("SELECT * FROM t_article WHERE source = :source")
    fun getArticlesBySource(source: String): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArticle(articleList: List<ArticleEntity>)

    @Delete
    fun deleteArticle(articleList: List<ArticleEntity>)

}