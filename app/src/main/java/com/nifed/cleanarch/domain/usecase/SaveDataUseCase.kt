package com.nifed.cleanarch.domain.usecase

import com.nifed.cleanarch.domain.model.UserNameModel
import com.nifed.cleanarch.domain.repository.UserRepository

class SaveDataUseCase(private val saveUserRepository: UserRepository) {
    fun execute(data: UserNameModel): Boolean{
        return saveUserRepository.saveUserName(data)
    }
}