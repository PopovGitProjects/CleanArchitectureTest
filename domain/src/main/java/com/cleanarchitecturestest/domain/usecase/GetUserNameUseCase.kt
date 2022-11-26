package com.cleanarchitecturestest.domain.usecase

import com.cleanarchitecturestest.domain.models.UserName
import com.cleanarchitecturestest.domain.repository.UserRepository

class GetUserNameUseCase (private val userRepository: UserRepository) {
    fun execute(): UserName {
        return UserName(
            firstName = userRepository.getName().firstName,
            lastName = userRepository.getName().lastName)
    }
}