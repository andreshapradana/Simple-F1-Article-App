package com.dicoding.mysimpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class ArticleDetailActivity : AppCompatActivity() {

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_article_detail)

    val imgArticleDetail: ImageView = findViewById(R.id.img_article_detail)
    val tvTitleDetail: TextView = findViewById(R.id.tv_title_detail)
    val tvDescriptionDetail: TextView = findViewById(R.id.tv_description_detail)

    val article = intent.getParcelableExtra<Article>("article")

    tvTitleDetail.text = article?.title
    tvDescriptionDetail.text = article?.description

    Glide.with(this)
        .load(article?.photo)
        .placeholder(android.R.drawable.ic_menu_gallery)
        .error(android.R.drawable.ic_menu_report_image)
        .into(imgArticleDetail)
}
}