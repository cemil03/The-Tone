package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(private val userRepository: UserRepository) {
    fun execute(userName:String, password: String ): Flow<List<User>> {
        return userRepository.loginUser(userName, password)
    }
}