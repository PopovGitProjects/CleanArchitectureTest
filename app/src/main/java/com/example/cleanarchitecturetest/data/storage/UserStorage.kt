package com.example.cleanarchitecturetest.data.storage

import com.example.cleanarchitecturetest.damain.models.UserName
import com.example.cleanarchitecturetest.data.storage.models.User

interface UserStorage {
    fun save(param: User): Boolean
    fun get(): User
}