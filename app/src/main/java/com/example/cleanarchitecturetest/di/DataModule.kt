package com.example.cleanarchitecturetest.di

import com.cleanarchitecturestest.data.repository.UserRepositoryImpl
import com.cleanarchitecturestest.data.storage.UserStorage
import com.cleanarchitecturestest.data.storage.sharedfref.SharedPrefUserStorage
import com.cleanarchitecturestest.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module{
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}