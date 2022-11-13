package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserDataUseCase(private val userRepository: UserRepository) {
    fun execute(): Flow<List<User>> {
        return userRepository.getUserData()
    }
}