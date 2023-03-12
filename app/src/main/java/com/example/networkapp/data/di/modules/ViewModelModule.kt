package com.example.networkapp.data.di.modules

import androidx.lifecycle.ViewModel
import com.example.networkapp.data.di.ViewModelKey
import com.example.networkapp.ui.CatViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CatViewModel::class)
    fun bindNewsViewModel(viewModel: CatViewModel): ViewModel
}