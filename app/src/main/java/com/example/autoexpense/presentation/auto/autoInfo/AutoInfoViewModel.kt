package com.example.autoexpense.presentation.auto.autoInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoexpense.domain.models.AutoInfo
import com.example.autoexpense.domain.usecase.GetAutoInfoUseCase

class AutoInfoViewModel(private val getAutoInfoUseCase: GetAutoInfoUseCase) : ViewModel() {

    private var autoInfoMutableLiveData = MutableLiveData<AutoInfo>()
    val autoInfoLiveData: LiveData<AutoInfo> = autoInfoMutableLiveData

    fun get() {
        val autoInfo: AutoInfo = getAutoInfoUseCase.execute()
        autoInfoMutableLiveData.value = autoInfo
    }

}