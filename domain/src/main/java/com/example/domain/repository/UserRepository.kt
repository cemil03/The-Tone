package com.example.domain.repository

import com.example.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User)
    fun getUserData(): Flow<List<User>>
}