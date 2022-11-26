package com.cleanarchitecturestest.data.storage

import com.cleanarchitecturestest.data.storage.models.User

interface UserStorage {
    fun save(param: User): Boolean
    fun get(): User
}