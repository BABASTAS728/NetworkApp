package com.example.networkapp.ui

import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.networkapp.CatsApp
import com.example.networkapp.R
import com.example.networkapp.data.di.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private val catViewModel: CatViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as CatsApp).appComponent.inject(this)
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
                catViewModel.getCatImage(serverBreeds[spinner.selectedItemPosition])
            }

            catViewModel.catLiveData.observe(this) {
                Glide
                    .with(this)
                    .load(it[0].imageUrl)
                    .into(imageView)
            }
        }
    }
}