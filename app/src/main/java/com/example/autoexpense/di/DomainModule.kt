package com.example.autoexpense.di

import com.example.autoexpense.domain.usecase.EditAutoInfoUseCase
import com.example.autoexpense.domain.usecase.GetAutoInfoUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetAutoInfoUseCase> {
        GetAutoInfoUseCase(autoInfoRepository = get())
    }

    factory<EditAutoInfoUseCase> {
        EditAutoInfoUseCase(autoInfoRepository = get())
    }

}