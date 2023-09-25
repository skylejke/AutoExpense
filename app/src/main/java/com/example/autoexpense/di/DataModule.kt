package com.example.autoexpense.di

import android.content.Context
import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.data.storage.AutoInfoStorage
import com.example.autoexpense.data.storage.AutoInfoStorageImpl
import com.example.autoexpense.domain.repository.AutoInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideAutoInfoStorageImpl(@ApplicationContext context: Context): AutoInfoStorage {
        return AutoInfoStorageImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideAutoInfoRepositoryImpl(autoInfoStorage: AutoInfoStorageImpl): AutoInfoRepository {
        return AutoInfoRepositoryImpl(autoInfoStorage)
    }
}