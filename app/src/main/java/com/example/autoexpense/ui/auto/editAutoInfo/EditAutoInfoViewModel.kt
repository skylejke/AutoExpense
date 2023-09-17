package com.example.autoexpense.ui.auto.editAutoInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoexpense.domain.models.EditAutoInfo
import com.example.autoexpense.domain.usecase.EditAutoInfoUseCase

class EditAutoInfoViewModel(private val editAutoInfoUseCase: EditAutoInfoUseCase) : ViewModel() {

    private val editAutoInfoMutableLiveData = MutableLiveData<EditAutoInfo>()
    val editAutoInfoLiveData: LiveData<EditAutoInfo> = editAutoInfoMutableLiveData

    fun edit(
        brand: String,
        model: String,
        mileage: Int,
        power: Int,
        fuelType: String,
        year: Int
    ) {
        val param =
            EditAutoInfo(
                brand = brand,
                model = model,
                mileage = mileage,
                power = power,
                fuelType = fuelType,
                year = year
            )
        editAutoInfoUseCase.execute(param = param)
        editAutoInfoMutableLiveData.value = param
    }
}