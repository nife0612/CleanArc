package com.nifed.cleanarch.data.storage

import com.nifed.cleanarch.data.storage.model.UserData

interface UserStorage {
    fun save(userNameModel: UserData): Boolean

    fun get(): UserData
}