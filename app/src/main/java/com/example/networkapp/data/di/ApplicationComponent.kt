package com.example.networkapp.data.di

import android.content.Context
import com.example.networkapp.data.di.modules.NetworkModule
import com.example.networkapp.data.di.modules.RepositoryModule
import com.example.networkapp.data.di.modules.ViewModelModule
import com.example.networkapp.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, NetworkModule::class, RepositoryModule::class])
interface ApplicationComponent{
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(activity: MainActivity)
}