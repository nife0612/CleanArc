package com.nifed.cleanarch.domain.usecase

import com.nifed.cleanarch.domain.model.UserName

class GetDataUseCase {
    fun execute(): UserName{
        return UserName(firstName = "Nicole", secondName = "Mar")
    }
}