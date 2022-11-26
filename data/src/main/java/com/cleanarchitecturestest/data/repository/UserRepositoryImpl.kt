package com.cleanarchitecturestest.data.repository

import com.cleanarchitecturestest.data.storage.UserStorage
import com.cleanarchitecturestest.data.storage.models.User
import com.cleanarchitecturestest.domain.models.SaveUserNameParam
import com.cleanarchitecturestest.domain.models.UserName
import com.cleanarchitecturestest.domain.repository.UserRepository


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
    private fun mapToStorage(userName: SaveUserNameParam): User {
        return User(firstName = userName.name, lastName = "")
    }
}