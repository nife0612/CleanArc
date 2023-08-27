package com.nifed.cleanarch.domain.usecase

import com.nifed.cleanarch.domain.model.UserNameModel
import com.nifed.cleanarch.domain.repository.UserRepository

class GetDataUseCase(private val repository: UserRepository) {
    fun execute(): UserNameModel{
        return repository.getUserName()
    }
}