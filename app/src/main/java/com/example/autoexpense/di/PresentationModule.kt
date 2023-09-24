package com.example.autoexpense.di

import com.example.autoexpense.presentation.auto.autoInfo.AutoInfoViewModel
import com.example.autoexpense.presentation.auto.editAutoInfo.EditAutoInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel<AutoInfoViewModel> {
        AutoInfoViewModel(getAutoInfoUseCase = get())
    }

    viewModel<EditAutoInfoViewModel> {
        EditAutoInfoViewModel(editAutoInfoUseCase = get())
    }

}