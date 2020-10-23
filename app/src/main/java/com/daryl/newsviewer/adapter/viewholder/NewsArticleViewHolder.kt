package com.daryl.newsviewer.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daryl.newsviewer.R
import com.daryl.newsviewer.load
import com.daryl.newsviewer.model.Article
import kotlinx.android.synthetic.main.layout_news_article_single.view.*

/**
 * @author Daryl Richardson
 */
class NewsArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(article: Article) = with(itemView) {
        tv_author.text = article.author
        tv_publish_date.text = article.publishedAt
        tv_title.text = article.title
        article.urlToImage?.let { iv_article_image.load(it) { requestCreator -> requestCreator.fit().centerCrop() } }
            ?: iv_article_image.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
    }
}