package com.example.domain.repository

import com.example.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun loginUser(userName: String, password: String): User?
}