package com.example.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.data.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE userName LIKE :userName AND password LIKE :password")
    suspend fun getUser(userName: String, password: String): UserEntity?

    @Insert
    suspend fun insertUser(user: UserEntity)

}