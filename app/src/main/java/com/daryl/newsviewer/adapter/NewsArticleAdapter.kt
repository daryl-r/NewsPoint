package com.daryl.newsviewer.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daryl.newsviewer.R
import com.daryl.newsviewer.adapter.viewholder.NewsArticleViewHolder
import com.daryl.newsviewer.inflate
import com.daryl.newsviewer.model.Article

/**
 * @author Daryl Richardson
 */
class NewsArticleAdapter(private val articles: List<Article>) : RecyclerView.Adapter<NewsArticleViewHolder>() {

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) = holder.bind(getItem(position))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder =
        NewsArticleViewHolder(parent.inflate(R.layout.layout_news_article_single))


    override fun getItemCount(): Int = articles.size

    private fun getItem(position: Int): Article = articles[position]

}