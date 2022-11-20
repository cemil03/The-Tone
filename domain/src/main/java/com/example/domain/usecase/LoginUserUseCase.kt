package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(private val userRepository: UserRepository) {
    suspend fun execute(userName:String, password: String ): User? {
        return userRepository.loginUser(userName, password)
    }
}