package com.example.autoexpense.data.storage

import com.example.autoexpense.data.storage.models.Auto

interface AutoInfoStorage {

    fun edit(auto: Auto): Boolean

    fun get(): Auto
}