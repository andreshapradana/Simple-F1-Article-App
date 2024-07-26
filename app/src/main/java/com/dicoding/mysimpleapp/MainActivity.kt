package com.dicoding.mysimpleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListArticleAdapter.OnItemClickListener {
    private lateinit var rvArticle: RecyclerView
    private val list = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvArticle = findViewById(R.id.rv_articles)
        rvArticle.setHasFixedSize(true)

        list.addAll(getListArticles())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this, AboutActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListArticles(): ArrayList<Article> {
        val dataTitle = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listArticle = ArrayList<Article>()
        for (i in dataTitle.indices) {
            val article = Article(dataTitle[i], dataDescription[i], dataPhoto[i])
            listArticle.add(article)
        }
        return listArticle
    }

    override fun onItemClick(article: Article) {
        val intent = Intent(this, ArticleDetailActivity::class.java)
        intent.putExtra("article", article)
        startActivity(intent)
    }

    private fun showRecyclerList() {
        rvArticle.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListArticleAdapter(list, this)
        rvArticle.adapter = listArticleAdapter
    }
}