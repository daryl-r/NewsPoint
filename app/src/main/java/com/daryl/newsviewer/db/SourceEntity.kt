package com.daryl.newsviewer.db

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daryl.newsviewer.NewsConstants

/**
 * @author Daryl Richardson
 */
@Entity(tableName = NewsConstants.T_SOURCE)
class SourceEntity(
        @PrimaryKey @NonNull var id: String = "",
        var name: String? = "",
        var description: String? = "",
        var url: String? = "",
        var category: String? = "",
        var language: String? = "",
        var country: String? = ""
)