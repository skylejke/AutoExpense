package com.example.autoexpense.di

import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.domain.usecase.EditAutoInfoUseCase
import com.example.autoexpense.domain.usecase.GetAutoInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetAutoInfoUseCase(autoInfoRepository: AutoInfoRepositoryImpl): GetAutoInfoUseCase {
        return GetAutoInfoUseCase(autoInfoRepository = autoInfoRepository)
    }

    @Provides
    fun provideEditAutoInfoUseCase(autoInfoRepository: AutoInfoRepositoryImpl): EditAutoInfoUseCase {
        return EditAutoInfoUseCase(autoInfoRepository = autoInfoRepository)
    }
}