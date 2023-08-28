package com.nifed.cleanarch.domain.repository

import com.nifed.cleanarch.domain.model.UserNameModel

interface UserRepository {
    fun saveUserName(userName: UserNameModel): Boolean

    fun getUserName(): UserNameModel
}
