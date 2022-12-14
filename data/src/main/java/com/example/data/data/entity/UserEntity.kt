package com.example.data.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val email: String,
    val password: String,
)