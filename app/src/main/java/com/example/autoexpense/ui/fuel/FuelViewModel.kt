package com.example.autoexpense.ui.fuel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FuelViewModel : ViewModel() {
    private val fuelMutableLiveData = MutableLiveData<String>().apply {
        value = "Топливо"
    }
    val fuelLiveData: LiveData<String> = fuelMutableLiveData
}