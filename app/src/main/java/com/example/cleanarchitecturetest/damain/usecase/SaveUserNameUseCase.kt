package com.example.cleanarchitecturetest.damain.usecase

import com.example.cleanarchitecturetest.damain.models.SaveUserNameParam
import com.example.cleanarchitecturetest.damain.repository.UserRepository

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
