package com.example.cleanarchitecturetest.damain.repository

import com.example.cleanarchitecturetest.damain.models.SaveUserNameParam
import com.example.cleanarchitecturetest.damain.models.UserName

interface UserRepository {
    fun getName(): UserName
    fun saveName(param: SaveUserNameParam): Boolean
}