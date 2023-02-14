package com.example.networkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.networkapp.ui.CatViewModel

class MainActivity : AppCompatActivity() {

    private val catViewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val imageView = findViewById<ImageView>(R.id.imageView)
//        val button = findViewById<Button>(R.id.button)
//        button.setOnClickListener {
//            catViewModel.catLiveData.observe(this) {
//                Glide
//                    .with(this)
//                    .load(it)
//                    .into(imageView)
//            }
//            catViewModel.getCatImage()
//        }
    }
}