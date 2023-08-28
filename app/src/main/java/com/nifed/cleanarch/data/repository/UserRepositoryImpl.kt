package com.nifed.cleanarch.data.repository

import com.nifed.cleanarch.data.storage.UserStorage
import com.nifed.cleanarch.data.storage.model.UserData
import com.nifed.cleanarch.domain.model.UserNameModel
import com.nifed.cleanarch.domain.repository.UserRepository



class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


    override fun saveUserName(userName: UserNameModel): Boolean {

        return userStorage.save(mapToStorage(userName))

    }

    override fun getUserName(): UserNameModel {

        return mapToDomain(userStorage.get())

    }

    private fun mapToDomain(userData: UserData): UserNameModel{
        return UserNameModel(userData.firstName, userData.secondName)
    }

    private fun mapToStorage(userNameModel: UserNameModel): UserData{
        return UserData(userNameModel.firstName, userNameModel.secondName)
    }
}