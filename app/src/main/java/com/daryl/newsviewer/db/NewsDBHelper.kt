package com.daryl.newsviewer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daryl.newsviewer.NewsConstants

/**
 * @author Daryl Richardson
 */
@Database(entities = [SourceEntity::class, ArticleEntity::class], version = 1)
abstract class NewsDBHelper : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
    abstract fun getSourceDao(): SourceDao

    companion object {
        private var db: NewsDBHelper? = null

        fun getInstance(context: Context): NewsDBHelper {
            if (db == null) {
                db = Room.databaseBuilder(context, NewsDBHelper::class.java, NewsConstants.DB_NAME).build()
            }
            return db!!
        }
    }

}