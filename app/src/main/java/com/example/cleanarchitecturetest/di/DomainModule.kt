package com.example.cleanarchitecturetest.di

import com.cleanarchitecturestest.domain.usecase.GetUserNameUseCase
import com.cleanarchitecturestest.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}