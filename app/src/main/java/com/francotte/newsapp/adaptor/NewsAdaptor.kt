package com.francotte.newsapp.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.francotte.newsapp.databinding.ListItemBinding
import com.francotte.newsapp.retrofit.response.Article
import kotlinx.coroutines.flow.last
import javax.inject.Inject


class NewsAdaptor : RecyclerView.Adapter<NewsAdaptor.NewsViewHolder>() {


    @Inject
    lateinit var glide: RequestManager

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }

    private val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        ))

    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.binding.textViewListItem.text = article.description
        Glide.with(holder.binding.root).load(article.urlToImage).into(holder.binding.imageListItem)
    }

    inner class NewsViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}