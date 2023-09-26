package com.example.autoexpense.presentation.auto.autoInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoexpense.domain.models.AutoInfo
import com.example.autoexpense.domain.usecase.GetAutoInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class AutoInfoViewModel @Inject constructor(private val getAutoInfoUseCase: GetAutoInfoUseCase) : ViewModel() {

    private var autoInfoMutableLiveData = MutableLiveData<AutoInfo>()
    val autoInfoLiveData: LiveData<AutoInfo> = autoInfoMutableLiveData

    fun getAutoInfo() {
        val autoInfo: AutoInfo = getAutoInfoUseCase.execute()
        autoInfoMutableLiveData.value = autoInfo
    }
}