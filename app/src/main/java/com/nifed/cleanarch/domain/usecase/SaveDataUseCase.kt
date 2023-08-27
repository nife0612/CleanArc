package com.nifed.cleanarch.domain.usecase

import com.nifed.cleanarch.domain.model.SaveUserName

class SaveDataUseCase {
    fun execute(data: SaveUserName): Boolean{
        return data.name.isNotEmpty()
    }
}