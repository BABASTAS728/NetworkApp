package com.example.networkapp

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.networkapp.ui.CatViewModel

class MainActivity : AppCompatActivity() {

    private val catViewModel by viewModels<CatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val breeds = resources.getStringArray(R.array.breeds)
        val serverBreeds = resources.getStringArray(R.array.server_breeds)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, breeds
            )
            spinner.adapter = adapter

            val imageView = findViewById<ImageView>(R.id.imageView)
            val button = findViewById<Button>(R.id.button)
            button.setOnClickListener {
                catViewModel.catLiveData.observe(this) {
                    Glide
                        .with(this)
                        .load(it[0].imageUrl)
                        .into(imageView)
                }
                catViewModel.getCatImage(serverBreeds[spinner.selectedItemPosition])
            }
        }
    }
}