package com.nifed.clanarch.data.repository

import com.nifed.clanarch.data.storage.UserStorage
import com.nifed.clanarch.data.storage.model.UserDataModel
import com.nifed.cleanarch.domain.model.UserNameModel
import com.nifed.cleanarch.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


    override fun saveUserName(userName: UserNameModel): Boolean {

        return userStorage.save(mapToStorage(userName))

    }

    override fun getUserName(): UserNameModel {

        return mapToDomain(userStorage.get())

    }

    private fun mapToDomain(userDataModel: UserDataModel): UserNameModel{
        return UserNameModel(userDataModel.firstName, userDataModel.secondName)
    }

    private fun mapToStorage(userNameModel: UserNameModel): UserDataModel {
        return UserDataModel(userNameModel.firstName, userNameModel.secondName)
    }
}