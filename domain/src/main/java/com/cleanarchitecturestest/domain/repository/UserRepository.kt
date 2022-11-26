package com.cleanarchitecturestest.domain.repository

import com.cleanarchitecturestest.domain.models.SaveUserNameParam
import com.cleanarchitecturestest.domain.models.UserName

interface UserRepository {
    fun getName(): UserName
    fun saveName(param: SaveUserNameParam): Boolean
}