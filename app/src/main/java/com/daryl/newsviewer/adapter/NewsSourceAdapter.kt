package com.daryl.newsviewer.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daryl.newsviewer.R
import com.daryl.newsviewer.adapter.viewholder.NewsSourceViewHolder
import com.daryl.newsviewer.db.SourceEntity
import com.daryl.newsviewer.inflate

/**
 * @author Daryl Richardson
 */
class NewsSourceAdapter(private val listener: (SourceEntity) -> Unit, private var sourceList: List<SourceEntity>) :
    RecyclerView.Adapter<NewsSourceViewHolder>() {


    override fun getItemCount(): Int {
        return sourceList.size
    }

    private fun getItem(position: Int): SourceEntity {
        return sourceList[position]
    }

    override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) =
        holder.bind(getItem(position), listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder =
        NewsSourceViewHolder(parent.inflate(R.layout.layout_news_source_single))

    fun updateDataSet(data: List<SourceEntity>) {
        sourceList = data
        notifyDataSetChanged()
    }
}