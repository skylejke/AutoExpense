package com.example.autoexpense.data.repository

import com.example.autoexpense.data.storage.AutoInfoStorage
import com.example.autoexpense.data.storage.models.Auto
import com.example.autoexpense.domain.models.AutoInfo
import com.example.autoexpense.domain.models.EditAutoInfo
import com.example.autoexpense.domain.repository.AutoInfoRepository

class AutoInfoRepositoryImpl(private val autoInfoStorage: AutoInfoStorage) : AutoInfoRepository {

    override fun editInfo(editParam: EditAutoInfo): Boolean {
        val auto = mapToStorage(editParam)
        return autoInfoStorage.edit(auto)
    }

    override fun getInfo(): AutoInfo {
        val autoInfo = autoInfoStorage.get()
        return mapToDomain(autoInfo)
    }

    private fun mapToStorage(editParam: EditAutoInfo): Auto {
        return Auto(
            brand = editParam.brand,
            model = editParam.model,
            mileage = editParam.mileage,
            power = editParam.power,
            fuelType = editParam.fuelType,
            year = editParam.year
        )
    }

    private fun mapToDomain(autoInfo: Auto): AutoInfo {
        return AutoInfo(
            brand = autoInfo.brand,
            model = autoInfo.model,
            mileage = autoInfo.mileage,
            power = autoInfo.power,
            fuelType = autoInfo.fuelType,
            year = autoInfo.year
        )
    }
}