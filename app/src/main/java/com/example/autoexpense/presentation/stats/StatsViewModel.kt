package com.example.autoexpense.presentation.stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StatsViewModel : ViewModel() {
    private val statsMutableLiveData = MutableLiveData<String>().apply {
        value = "Статистика"
    }
    val statsLiveData: LiveData<String> = statsMutableLiveData
}