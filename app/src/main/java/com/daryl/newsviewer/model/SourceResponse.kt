package com.daryl.newsviewer.model

import com.google.gson.annotations.SerializedName

/**
 * @author Daryl Richardson
 */
data class SourceResponse(
    @SerializedName("status") var status: String?,
    @SerializedName("sources") var sources: List<Source>
)

data class Source(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("url") var url: String?,
    @SerializedName("category") var category: String?,
    @SerializedName("language") var language: String?,
    @SerializedName("country") var country: String?
)