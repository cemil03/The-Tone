package com.example.mp3.di

import com.example.mp3.presentation.authorization.login.LoginViewModel
import com.example.mp3.presentation.authorization.signUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<SignUpViewModel> {
        SignUpViewModel(registerUserUseCase = get())
    }

    viewModel<LoginViewModel> {
        LoginViewModel(loginUserUseCase = get())
    }

}