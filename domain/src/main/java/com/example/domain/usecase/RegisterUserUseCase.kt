package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository

class RegisterUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: User) {
        userRepository.insertUser(user)
    }

}