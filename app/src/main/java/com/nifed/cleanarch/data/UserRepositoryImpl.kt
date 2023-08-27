package com.nifed.cleanarch.data

import android.content.Context
import com.nifed.cleanarch.domain.repository.UserRepository
import com.nifed.cleanarch.domain.model.UserNameModel

private const val SHARED_PREF_NAME = "shar_pref_name"
private const val KEY_NAME = "first_name"
private const val DEFAULT_NAME = "Default name"

class UserRepositoryImpl(context: Context): UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)


    override fun saveUserName(userName: UserNameModel): Boolean{

        sharedPreferences.edit().putString(KEY_NAME, userName.name).apply()

        return true
    }

    override fun getUserName(): UserNameModel{
        val name = sharedPreferences.getString(KEY_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserNameModel(name = name)
    }
}