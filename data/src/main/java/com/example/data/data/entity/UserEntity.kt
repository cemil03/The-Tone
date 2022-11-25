package com.example.data.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.User


@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val email: String,
    val password: String,
)

internal fun UserEntity.toDomainEntity() = User(
    id = id,
    userName = userName,
    email = email,
    password = password,
)

internal fun User.toDataModel() = UserEntity(
    id = id,
    userName = userName,
    email = email,
    password = password,
)