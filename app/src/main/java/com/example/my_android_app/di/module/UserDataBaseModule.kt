package com.example.my_android_app.di.module

import android.content.Context
import com.example.my_android_app.data.model.local.UserDao
import com.example.my_android_app.data.model.local.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UserDataBaseModule {
    @Provides
    fun providerUserDataBase(context: Context): UserDataBase {
        return UserDataBase.getInstance(context)
    }

    @Provides
    fun providerUserDataDAO(context: Context): UserDao {
        return UserDataBase.getInstance(context).userDao()
    }
}