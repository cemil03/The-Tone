package com.example.data.repository

import com.example.data.data.dao.UserDao
import com.example.data.data.entity.toDataModel
import com.example.data.data.entity.toDomainEntity
import com.example.domain.entity.User
import com.example.domain.repository.UserRepository

class UserRepositoryImpl(
    private val dao: UserDao,
) : UserRepository {

    override suspend fun insertUser(user: User) {
        dao.insertUser(user.toDataModel())
    }

    override suspend fun loginUser(userName: String, password: String): User? {
        return dao.getUser(userName, password)?.toDomainEntity()
    }

}