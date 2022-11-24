package com.example.cleanarchitecturetest.damain.usecase

import com.example.cleanarchitecturetest.damain.models.UserName
import com.example.cleanarchitecturetest.damain.repository.UserRepository

class GetUserNameUseCase (private val userRepository: UserRepository) {
    fun execute(): UserName {
        return UserName(firstName = "Tom", lastName = "Collins")
    }
}