package com.daryl.newsviewer.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daryl.newsviewer.db.SourceEntity
import kotlinx.android.synthetic.main.layout_news_source_single.view.*

/**
 * @author Daryl Richardson
 */
class NewsSourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(source: SourceEntity, listener: (SourceEntity) -> Unit) = with(itemView) {
        tv_source_name.text = source.name
        tv_source_description.text = source.description
        tv_category.text = source.category
        itemView.setOnClickListener { listener(source) }
    }
}