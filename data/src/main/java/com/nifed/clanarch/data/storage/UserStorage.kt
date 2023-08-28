package com.nifed.clanarch.data.storage

import com.nifed.clanarch.data.storage.model.UserDataModel

interface UserStorage {
    fun save(userDataModel: UserDataModel): Boolean

    fun get(): UserDataModel
}