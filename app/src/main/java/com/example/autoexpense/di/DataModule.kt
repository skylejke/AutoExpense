package com.example.autoexpense.di

import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.data.storage.AutoInfoStorage
import com.example.autoexpense.data.storage.AutoInfoStorageImpl
import com.example.autoexpense.domain.repository.AutoInfoRepository
import org.koin.dsl.module

val dataModule = module {

    single<AutoInfoStorage> {
        AutoInfoStorageImpl(context = get())
    }

    single<AutoInfoRepository> {
        AutoInfoRepositoryImpl(autoInfoStorage = get())
    }

}