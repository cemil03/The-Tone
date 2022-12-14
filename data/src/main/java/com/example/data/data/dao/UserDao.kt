package com.example.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getDataUser() : Flow<List<UserEntity>>

    @Insert
    suspend fun insertUser(user: UserEntity)

}