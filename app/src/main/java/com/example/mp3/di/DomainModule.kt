package com.example.mp3.di

import com.example.domain.usecase.GetUserUseCase
import com.example.domain.usecase.RegisterUserUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        RegisterUserUseCase(userRepository = get())
    }

    factory {
        GetUserUseCase(userRepository = get())
    }

}