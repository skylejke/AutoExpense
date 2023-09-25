package com.example.autoexpense.domain.usecase

import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.domain.models.AutoInfo
import javax.inject.Inject

class GetAutoInfoUseCase  @Inject constructor(private val autoInfoRepository: AutoInfoRepositoryImpl) {

    fun execute(): AutoInfo {
        return autoInfoRepository.getInfo()
    }

}