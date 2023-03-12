package com.example.networkapp.data.di.modules

import com.example.networkapp.data.RepositoryImpl
import com.example.networkapp.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun getRepository(impl: RepositoryImpl): Repository
}