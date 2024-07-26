package com.dicoding.mysimpleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnBackActivity: Button = findViewById(R.id.button_back)
        btnBackActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        when (v?.id) {
            R.id.button_back -> {
                val backIntent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }
}