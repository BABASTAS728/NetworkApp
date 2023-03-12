package com.example.networkapp

import android.app.Application
import com.example.networkapp.data.di.ApplicationComponent
import com.example.networkapp.data.di.DaggerApplicationComponent
class CatsApp : Application() {
    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}