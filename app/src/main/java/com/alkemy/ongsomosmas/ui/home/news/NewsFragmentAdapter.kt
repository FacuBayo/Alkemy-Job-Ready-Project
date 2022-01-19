package com.alkemy.ongsomosmas.ui.home.news

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.model.NewsResponse
import com.alkemy.ongsomosmas.databinding.ItemNewsFragmentBinding
import com.squareup.picasso.Picasso

class NewsFragmentAdapter(private val newsList: List<NewsResponse>, private val context: Context) :
    RecyclerView.Adapter<NewsFragmentAdapter.NewsViewHolder>() {


    inner class NewsViewHolder(val binding: ItemNewsFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun render(news: NewsResponse) {
            with(binding) {
                tvNewsTitle.text = news.name
                Picasso.get().load(news.image).into(ivNews)
                tvNewsDescription.text = news.content
                tvNewsCreatedAt.text = context.getString(R.string.news_published).plus(" ").plus(news.createdAt?.take(10))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            ItemNewsFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.render(newsList[position])

    override fun getItemCount(): Int = newsList.size
}