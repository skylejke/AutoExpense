package com.example.autoexpense.domain.usecase

import com.example.autoexpense.data.repository.AutoInfoRepositoryImpl
import com.example.autoexpense.domain.models.EditAutoInfo
import javax.inject.Inject

class EditAutoInfoUseCase  @Inject constructor(private val autoInfoRepository: AutoInfoRepositoryImpl) {
    fun execute(param: EditAutoInfo): Boolean {
        return autoInfoRepository.editInfo(editParam = param)
    }
}