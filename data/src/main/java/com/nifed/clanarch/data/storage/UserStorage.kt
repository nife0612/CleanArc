package com.nifed.cleanarch.data.storage

import com.nifed.cleanarch.data.storage.model.UserDataModel

interface UserStorage {
    fun save(userDataModel: UserDataModel): Boolean

    fun get(): UserDataModel
}