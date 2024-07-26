package com.dicoding.mysimpleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListArticleAdapter(private val listArticle: ArrayList<Article>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ListArticleAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_article, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, photo) = listArticle[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvTitle.text = title
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            listener.onItemClick(listArticle[position])
        }
    }

    override fun getItemCount(): Int = listArticle.size

    interface OnItemClickListener {
        fun onItemClick(article: Article)
    }
}