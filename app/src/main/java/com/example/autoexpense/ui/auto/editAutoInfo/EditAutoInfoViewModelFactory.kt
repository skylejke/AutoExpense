package com.example.autoexpense.ui.auto.editAutoInfo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.data.storage.AutoInfoStorageImpl
import com.example.autoexpense.domain.usecase.EditAutoInfoUseCase

@Suppress("UNCHECKED_CAST")
class EditAutoInfoViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val autoInfoStorage by lazy(LazyThreadSafetyMode.NONE) { AutoInfoStorageImpl(context = context) }
    private val autoInfoRepository by lazy(LazyThreadSafetyMode.NONE) {
        AutoInfoRepositoryImpl(
            autoInfoStorage
        )
    }
    private val editAutoInfoUseCase by lazy(LazyThreadSafetyMode.NONE) {
        EditAutoInfoUseCase(
            autoInfoRepository = autoInfoRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditAutoInfoViewModel(editAutoInfoUseCase = editAutoInfoUseCase) as T
    }
}