package com.example.autoexpense.presentation.auto.editAutoInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.autoexpense.domain.models.EditAutoInfo
import com.example.autoexpense.domain.usecase.EditAutoInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class EditAutoInfoViewModel  @Inject constructor(private val editAutoInfoUseCase: EditAutoInfoUseCase) : ViewModel() {

    private val editAutoInfoMutableLiveData = MutableLiveData<EditAutoInfo>()

    fun editAutoInfo(
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