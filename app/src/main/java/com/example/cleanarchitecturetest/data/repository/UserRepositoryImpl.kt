package com.example.cleanarchitecturetest.data.repository

import com.example.cleanarchitecturetest.damain.models.SaveUserNameParam
import com.example.cleanarchitecturetest.damain.models.UserName
import com.example.cleanarchitecturetest.damain.repository.UserRepository
import com.example.cleanarchitecturetest.data.storage.UserStorage
import com.example.cleanarchitecturetest.data.storage.models.User


class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())
    }
    override fun saveName(param: SaveUserNameParam): Boolean {
        return userStorage.save(mapToStorage(param))
    }
    private fun mapToDomain(user: User):UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
    private fun mapToStorage(userName: SaveUserNameParam):User {
        return User(firstName = userName.name, lastName = "")
    }
}