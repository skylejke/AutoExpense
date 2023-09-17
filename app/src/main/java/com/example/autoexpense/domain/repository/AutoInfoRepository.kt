package com.example.autoexpense.domain.repository

import com.example.autoexpense.domain.models.AutoInfo
import com.example.autoexpense.domain.models.EditAutoInfo

interface AutoInfoRepository {
    fun editInfo(editParam: EditAutoInfo): Boolean

    fun getInfo(): AutoInfo
}