package com.example.data.repository

import com.example.data.data.dao.UserDao
import com.example.data.mapper.UserMapper
import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val dao: UserDao,
    private val userMapper: UserMapper
) : UserRepository {
    override suspend fun insertUser(user: User) {
        dao.insertUser(userMapper.mapToEntity(user))
    }

    override suspend fun loginUser(userName: String, password: String): User? {
        return userMapper.mapFromEntity(dao.loginUser(userName, password))
    }


}