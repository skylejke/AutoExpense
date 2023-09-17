package com.example.autoexpense.ui.auto.autoInfo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.data.storage.AutoInfoStorageImpl
import com.example.autoexpense.domain.usecase.GetAutoInfoUseCase

@Suppress("UNCHECKED_CAST")
class AutoInfoViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val autoInfoStorage by lazy(LazyThreadSafetyMode.NONE) { AutoInfoStorageImpl(context = context) }
    private val autoInfoRepository by lazy(LazyThreadSafetyMode.NONE) {
        AutoInfoRepositoryImpl(
            autoInfoStorage
        )
    }
    private val getAutoInfoUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetAutoInfoUseCase(
            autoInfoRepository = autoInfoRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AutoInfoViewModel(getAutoInfoUseCase = getAutoInfoUseCase) as T
    }
}


