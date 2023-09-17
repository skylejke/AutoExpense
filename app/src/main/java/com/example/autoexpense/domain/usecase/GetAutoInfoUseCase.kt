package com.example.autoexpense.domain.usecase

import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.domain.models.AutoInfo

class GetAutoInfoUseCase(private val autoInfoRepository: AutoInfoRepositoryImpl) {

    fun execute(): AutoInfo {
        return autoInfoRepository.getInfo()
    }

}