package com.arunkbabu.androidtesting.di

import com.arunkbabu.androidtesting.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}