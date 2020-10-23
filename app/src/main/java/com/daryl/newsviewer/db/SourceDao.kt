package com.daryl.newsviewer.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.daryl.newsviewer.NewsConstants

/**
 * @author Daryl Richardson
 */
@Dao
interface SourceDao {

    @Query("SELECT * FROM " + NewsConstants.T_SOURCE)
    fun getAllNewsSource(): LiveData<List<SourceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSources(source: List<SourceEntity>)

    @Delete
    fun deleteSource(source: List<SourceEntity>)
}
