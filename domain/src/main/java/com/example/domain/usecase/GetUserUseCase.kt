package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(userName:String, password: String ): User? {
        return userRepository.loginUser(userName, password)
    }

}