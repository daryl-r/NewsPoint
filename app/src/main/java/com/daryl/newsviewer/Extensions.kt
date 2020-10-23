package com.daryl.newsviewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

/**
 * @author Daryl Richardson
 */
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

val Context.picasso: Picasso get() = Picasso.with(this)


fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(path)).into(this)
}