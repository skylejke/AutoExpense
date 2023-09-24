package com.example.autoexpense.presentation.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServiceViewModel : ViewModel() {
    private val serviceMutableLiveData = MutableLiveData<String>().apply {
        value = "Сервис"
    }
    val serviceLiveData: LiveData<String> = serviceMutableLiveData
}