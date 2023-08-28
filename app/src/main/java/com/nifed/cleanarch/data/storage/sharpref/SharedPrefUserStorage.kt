package com.nifed.cleanarch.data.storage.sharpref

import android.content.Context
import com.nifed.cleanarch.data.storage.UserStorage
import com.nifed.cleanarch.data.storage.model.UserData


private const val SHARED_PREF_NAME = "shar_pref_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_SECOND_NAME = "second_name"
private const val DEFAULT_FIRST_NAME = "Default first name"
private const val DEFAULT_SECOND_NAME = "Default second name"
class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREF_NAME,
        Context.MODE_PRIVATE
    )
    override fun save(userNameModel: UserData): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userNameModel.firstName).apply()
        sharedPreferences.edit().putString(KEY_SECOND_NAME, userNameModel.secondName).apply()
        return true
    }

    override fun get(): UserData {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME, DEFAULT_SECOND_NAME) ?: DEFAULT_SECOND_NAME

        return UserData(
            firstName  = firstName,
            secondName = secondName
        )
    }
}