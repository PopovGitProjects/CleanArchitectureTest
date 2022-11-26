package com.cleanarchitecturestest.domain.usecase

import com.cleanarchitecturestest.domain.models.SaveUserNameParam
import com.cleanarchitecturestest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean{
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name){
            return true
        }
        val result: Boolean = userRepository.saveName(param = param)
        return result
    }
}
