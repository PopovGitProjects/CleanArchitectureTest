package com.cleanarchitecturestest.data.storage.sharedfref

import android.content.Context
import com.cleanarchitecturestest.data.storage.UserStorage
import com.cleanarchitecturestest.data.storage.models.User

private const val SHARED_PREF_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "lastname_name"
private const val DEFAULT_FIRST_NAME = "default_first_name"
private const val DEFAULT_LAST_NAME = "default_last_name"


class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: DEFAULT_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "")?: DEFAULT_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}