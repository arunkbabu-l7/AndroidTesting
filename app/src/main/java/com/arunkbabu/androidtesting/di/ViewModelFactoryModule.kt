package com.arunkbabu.androidtesting.di

import androidx.lifecycle.ViewModelProvider
import com.arunkbabu.androidtesting.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}