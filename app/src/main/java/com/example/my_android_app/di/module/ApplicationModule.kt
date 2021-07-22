package com.example.my_android_app.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [UserDataBaseModule::class])
class ApplicationModule {
    @Provides
    @Singleton
    fun providerContext(@ApplicationContext context: Context): Context {
        return context
    }
}